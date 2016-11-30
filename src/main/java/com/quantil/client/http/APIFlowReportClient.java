package com.quantil.client.http;

import java.text.DateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;

import com.mileweb.sdk.cloudview.model.Timezone;
import com.quantil.auth.APICredentials;
import com.quantil.entities.response.GenericResponse;
import com.quantil.http.HttpProcessor;
import com.quantil.interfaces.IFlowReportClient;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.service.ProjectData;

public class APIFlowReportClient implements IFlowReportClient {

static Logger LOG = QuantilTestRunner.LOG;
	

    String endpoint;
    String user;
    String pass;
    String currentDate;
    HttpProcessor proc;
    private static APIFlowReportClient exec;
    private static APICredentials current;

    private APIFlowReportClient(APICredentials cred) throws Exception {
        
    	
    	LOG.info("Initializing API Report client");
    	proc = new HttpProcessor(cred.getEndpoint(), cred.getUser(), cred.getKey());
    }
    
    public static APIFlowReportClient getClient(APICredentials cred) {
        
        if (exec == null || current != cred) { 
        	
        	try {
				exec = new APIFlowReportClient(cred);
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
	public GenericResponse rangeFlowReport(String domIdOrServiceType,
			Date dateFrom, Date dateTo, String rangeStart, String rangeEnd,
			Timezone tZone) {

		
		LOG.info("Executing Rangeflow report request");
		
		DateFormat formatter = ProjectData.format;

        String uri = String.format("/api/report/%s/rangeflow?datefrom=%s&dateto=%s&rangeStart=%s&rangeEnd=%s&rangeTz=%s", domIdOrServiceType,
                formatter.format(dateFrom),
                formatter.format(dateTo),
                rangeStart,
                rangeEnd,tZone).replaceAll("\\+", "%2B");


        return proc.performGet(uri);
	}


    public GenericResponse rangeFlowReport(Date dateFrom, Date dateTo, String rangeStart, String rangeEnd) { //den

        LOG.info("Executing Rangeflow report request");

        DateFormat formatter = ProjectData.format;

        String uri = String.format("/api/report/rangeflow?datefrom=%s&dateto=%s&rangeStart=%s&rangeEnd=%s",
                formatter.format(dateFrom),
                formatter.format(dateTo),
                rangeStart,
                rangeEnd).replaceAll("\\+", "%2B");

        return proc.performGet(uri);

    }

    public GenericResponse rangeFlowReport(String dateFrom, String dateTo, String rangeStart, String rangeEnd) {//den

        LOG.info("Executing Rangeflow report request");

         String uri = String.format("/api/report/rangeflow?datefrom=%s&dateto=%s&rangeStart=%s&rangeEnd=%s",
                dateFrom,
                dateTo,
                rangeStart,
                rangeEnd).replaceAll("\\+", "%2B");

        return proc.performGet(uri);

    }

    public GenericResponse rangeFlowReport(String domIdOrServiceType,
                                           Date dateFrom, Date dateTo, String rangeStart, String rangeEnd) {//den


        LOG.info("Executing Rangeflow report request");

        DateFormat formatter = ProjectData.format;

        String uri = String.format("/api/report/%s/rangeflow?datefrom=%s&dateto=%s&rangeStart=%s&rangeEnd=%s", domIdOrServiceType,
                formatter.format(dateFrom),
                formatter.format(dateTo),
                rangeStart,
                rangeEnd).replaceAll("\\+", "%2B");


        return proc.performGet(uri);
    }
   
}
