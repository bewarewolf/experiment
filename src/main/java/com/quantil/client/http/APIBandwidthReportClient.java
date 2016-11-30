package com.quantil.client.http;


import org.apache.logging.log4j.Logger;

import com.mileweb.sdk.cloudview.model.Timezone;
import com.quantil.auth.APICredentials;
import com.quantil.entities.response.GenericResponse;
import com.quantil.http.HttpProcessor;
import com.quantil.interfaces.IBandwidthReportClient;
import com.quantil.runners.QuantilTestRunner;

public class APIBandwidthReportClient implements IBandwidthReportClient {

	static Logger LOG = QuantilTestRunner.LOG;
	

    String endpoint;
    String user;
    String pass;
    String currentDate;
    HttpProcessor proc;
    private static APIBandwidthReportClient exec;
    private static APICredentials current;

    public APIBandwidthReportClient(String endpoint, String user, String pass) {

        this.endpoint = endpoint;
        this.user = user;
        this.pass = pass;

        proc = new HttpProcessor(endpoint, user, pass);
    }

    private APIBandwidthReportClient(APICredentials cred) throws Exception {
        
    	
    	LOG.info("Initializing API Report client");
    	proc = new HttpProcessor(cred.getEndpoint(), cred.getUser(), cred.getKey());
    }
    
    public static APIBandwidthReportClient getClient(APICredentials cred) {
        
        if (exec == null || current != cred) { 
        	
        	try {
				exec = new APIBandwidthReportClient(cred);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.error(e);
				throw new RuntimeException(e);
			}
        	current = cred;
        }
        
        return exec;
    }
        
    @Override
    public GenericResponse allDomainsBandwidthReport() {

    	LOG.info("Executing AllDomains Bandwidth report request");
    	
        String uri = "/api/report/alldomains/bandwidth";
        return proc.performGet(uri);
    }

    @Override
    public GenericResponse allDomainsBandwidthReport(Timezone timezone) {
    	
    	LOG.info("Executing AllDomains Bandwidth report request for timezone: " + timezone);
    	
        String uri = String.format("/api/report/alldomains/bandwidth?timezone=%s", timezone).replaceAll("\\+", "%2B");
        return proc.performGet(uri);
    }    
}
