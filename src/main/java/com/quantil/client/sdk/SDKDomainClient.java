package com.quantil.client.sdk;


import org.apache.logging.log4j.Logger;

import com.mileweb.sdk.cloudcdn.CloudCDNClient;
import com.mileweb.sdk.cloudcdn.model.CancelDomainResult;
import com.mileweb.sdk.cloudcdn.model.CreateDomainResult;
import com.mileweb.sdk.cloudcdn.model.DisableDomainResult;
import com.mileweb.sdk.cloudcdn.model.Domain;
import com.mileweb.sdk.cloudcdn.model.EnableDomainResult;
import com.mileweb.sdk.cloudcdn.model.GetDomainHistoryResult;
import com.mileweb.sdk.cloudcdn.model.ListDomainHistoryResult;
import com.mileweb.sdk.cloudcdn.model.QueryDomainResult;
import com.mileweb.sdk.cloudcdn.model.RestoreDomainResult;
import com.mileweb.sdk.cloudcdn.model.UpdateDomainResult;
import com.mileweb.sdk.cloudcdn.model.ListDomainResult;
import com.quantil.auth.APICredentials;
import com.quantil.client.response.ExceptionHandler;
import com.quantil.client.response.SDKResponseHandler;
import com.quantil.entities.response.domain.DomainHistoryResponse;
import com.quantil.entities.response.domain.DomainResponse;
import com.quantil.entities.response.domain.DomainSummaryListResponse;
import com.quantil.global.Helper;
import com.quantil.interfaces.IDomainClient;
import com.quantil.runners.QuantilTestRunner;



public class SDKDomainClient implements IDomainClient {

	static Logger LOG = QuantilTestRunner.LOG;
	
	private static SDKDomainClient exec;
    private final CloudCDNClient client;
    private static APICredentials current;
    
    private SDKDomainClient(APICredentials cred) throws Exception {
        
        // Initializing CloudCDNClient
    	LOG.info("Initializing CloudCDNClient");
        client = new CloudCDNClient(cred.getEndpoint(), cred.getUser(), cred.getKey());
    }
    
    public static SDKDomainClient getClient(APICredentials cred) {
        
        if (exec == null || current != cred) { 
        	
        	try {
				exec = new SDKDomainClient(cred);
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
	public DomainResponse enableDomain(String domainId) {
		
		LOG.info("Executing 'Enable' request for domain id " + domainId);
		
		try {
			
			EnableDomainResult result = client.enableDomain(domainId);
			
			return new DomainResponse(SDKResponseHandler.handleResponse(result));
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		} 
	}

	@Override
	public DomainResponse disableDomain(String domainId) {

		LOG.info("Executing 'Disable' request for domain id " + domainId);
		
		try {
			
			DisableDomainResult result = client.disableDomain(domainId);
			
			return new DomainResponse(SDKResponseHandler.handleResponse(result));
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		} 
	}

	@Override
	public DomainResponse cancelDomain(String domainId) {

		LOG.info("Executing 'Cancel' request for domain id " + domainId);
		
		try {
			
			CancelDomainResult result = client.cancelDomain(domainId);
			
			return new DomainResponse(SDKResponseHandler.handleResponse(result));
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		} 
	}

	@Override
	public DomainResponse restoreDomain(String domainId) {

		LOG.info("Executing 'Restore' request for domain id " + domainId);
		
		try {
			
			RestoreDomainResult result = client.restoreDomain(domainId);
			
			return new DomainResponse(SDKResponseHandler.handleResponse(result));
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		} 
	}

	@Override
	public DomainResponse createDomain() {

		Domain d = Helper.createRandomDomain();
		
		return createDomain(d);
	}

	@Override
	public DomainResponse createDomain(Domain domain) {

		LOG.info("Creating domain " + domain.getDomainName());
		
		try {
			
			CreateDomainResult result = client.createDomain(domain);
			
			DomainResponse resp = new DomainResponse(SDKResponseHandler.handleResponse(result));
			resp.setCname(result.getCname());
			resp.setDomain(domain);
			
			return resp;
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainResponse(ExceptionHandler.handleException(ex, null));
		} 
	}

	@Override
	public DomainResponse updateDomain(Domain domain) {

		LOG.info("Updating domain " + domain.getDomainId());
		
		try {
			
			UpdateDomainResult result = client.updateDomain(domain);
						
			DomainResponse resp = new DomainResponse(SDKResponseHandler.handleResponse(result));
			resp.setDomain(domain);
			
			return resp;
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainResponse(ExceptionHandler.handleException(ex, null));
		} 
	}

	@Override
	public DomainHistoryResponse getDomainHistory(String domainId) {
		
		LOG.info("Retrieving deployment history for domain " + domainId);
		
		try {
			
			ListDomainHistoryResult result = client.listDomainHistory(domainId);
			
			DomainHistoryResponse resp = new DomainHistoryResponse(SDKResponseHandler.handleResponse(result));
			resp.setRecordList(result.getDomainHistoryList());
			
			return resp;
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainHistoryResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		} 
	}

	@Override
	public DomainResponse getDomainHistoryRecord(String domainId, String recordId) {

		LOG.info("Retrieving history record " + recordId + " for domain " + domainId);
		
		try {
			
			GetDomainHistoryResult result = client.getDomainHistory(domainId, recordId);
			
			DomainResponse resp = new DomainResponse(SDKResponseHandler.handleResponse(result));
			resp.setDomain(result.getHistoryConfig());
			
			return resp;
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId +
																		   "; Record id: " + recordId));
		} 
	}

	@Override
	public DomainResponse getDomain(String domainId) {

		LOG.info("Retrieving domain " + domainId);
		
		try {
			
			QueryDomainResult result = client.queryDomain(domainId);
			
			DomainResponse resp = new DomainResponse(SDKResponseHandler.handleResponse(result));
			resp.setDomain(result.getDomain());
			
			return resp;
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		} 
	}

	@Override
	public DomainSummaryListResponse getDomainList() {

		LOG.info("Retrieving all domains");
		
		try {
			
			ListDomainResult result = client.listDomain();
			
			DomainSummaryListResponse resp = new DomainSummaryListResponse(SDKResponseHandler.handleResponse(result));
			
			resp.setSummaryList(result.getDomainSummaryList());
			
			return resp;
														
		} catch (Exception ex) {
			
			LOG.error("Exception caught", ex);
			return new DomainSummaryListResponse(ExceptionHandler.handleException(ex, null));
		} 
	}
}
