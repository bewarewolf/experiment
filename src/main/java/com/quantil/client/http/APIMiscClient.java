package com.quantil.client.http;

import org.apache.logging.log4j.Logger;


import com.quantil.auth.APICredentials;
import com.quantil.client.response.ExceptionHandler;
import com.quantil.entities.response.GenericResponse;
import com.quantil.http.HttpProcessor;
import com.quantil.runners.QuantilTestRunner;

public class APIMiscClient {

	private HttpProcessor proc;
		
	static Logger LOG = QuantilTestRunner.LOG;
	
	private static APIMiscClient exec;
	private static APICredentials current;
	
	private APIMiscClient(APICredentials cred) throws Exception {
	    
	    // Initializing CloudCDNClient
		//LOG.info("Initializing CloudCDNClient");
		proc = new HttpProcessor(cred.getEndpoint(), cred.getUser(), cred.getKey());
	}
	
	public static APIMiscClient getClient(APICredentials cred) {
	    
	    if (exec == null || current != cred) { 
	    	
	    	try {
				exec = new APIMiscClient(cred);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.error(e);
				
				throw new RuntimeException(e);
			}
	    	current = cred;
	    }
	    
	    return exec;
	}


	public APIMiscClient(String endpoint, String user, String pass) {
		
        proc = new HttpProcessor(endpoint, user, pass);
	}
	
	//@Override
	public GenericResponse getCacheIPList() {
		
		String uri = "/api/report/ip-cidrs";
		
		try {
			
			return proc.performGet(uri);
		} catch (Exception ex) {
			
			return ExceptionHandler.handleException(ex, null);
		}
	}
}
