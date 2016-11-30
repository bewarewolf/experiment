package com.quantil.client.http;

import com.mileweb.sdk.cloudcdn.model.Domain;
import com.quantil.client.response.ExceptionHandler;
import com.quantil.entities.response.domain.DomainHistoryResponse;
import com.quantil.entities.response.domain.DomainResponse;
import com.quantil.entities.response.domain.DomainSummaryListResponse;
import com.quantil.global.Helper;
import com.quantil.http.HttpProcessor;
import com.quantil.interfaces.IDomainClient;

public class APIDomainClient implements IDomainClient {

	private HttpProcessor proc;
	
	public APIDomainClient(String endpoint, String user, String pass) {
		
        proc = new HttpProcessor(endpoint, user, pass);
	}
	
	@Override
	public DomainResponse enableDomain(String domainId) {
		
		String uri = String.format("/api/disabledDomains/%s", domainId.replaceFirst("^0+(?!$)", ""));
		
		DomainResponse resp;
		
		try {
			
			resp = new DomainResponse(proc.performDelete(uri));
		} catch (Exception ex) {
			
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		}
		
		return resp;
	}

	@Override
	public DomainResponse disableDomain(String domainId) {

		String uri = String.format("/api/disabledDomains/%s", domainId.replaceFirst("^0+(?!$)", ""));
		
		DomainResponse resp;
		
		try {
			
			resp = new DomainResponse(proc.performPut(uri));
		} catch (Exception ex) {
			
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		}
		
		return resp;
	}

	@Override
	public DomainResponse cancelDomain(String domainId) {

		String uri = String.format("/api/cancelledDomains/%s", domainId.replaceFirst("^0+(?!$)", ""));
		
		DomainResponse resp;
		
		try {
			
			resp = new DomainResponse(proc.performPut(uri));
		} catch (Exception ex) {
			
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		}
		
		return resp;
	}

	@Override
	public DomainResponse restoreDomain(String domainId) {

		String uri = String.format("/api/cancelledDomains/%s", domainId.replaceFirst("^0+(?!$)", ""));
		
		DomainResponse resp;
		
		try {
			
			resp = new DomainResponse(proc.performDelete(uri));
		} catch (Exception ex) {
			
			return new DomainResponse(ExceptionHandler.handleException(ex, "Domain id: " + domainId));
		}
		
		return resp;
	}

	@Override
	public DomainResponse createDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainResponse createDomain(Domain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainResponse updateDomain(Domain domain) {

		String uri = String.format("/api/domain/%s", domain.getDomainId().replaceFirst("^0+(?!$)", ""));

		String body = "<?xml version = \"1.0\" encoding = \"UTF-8\"?>\n" +
				"<domain>\n" +
				"<version>1.0.0</version>\n" +
				"<domain-name>" + domain.getDomainName() + "</domain-name>\n" +
				"<service-type>" + domain.getServiceType() + "</service-type>\n" +
				"<cname>" + domain.getCname() + "</cname>\n" +
				"<service-areas>" + domain.getServiceArea() + "</service-areas>\n" +
				"<origin-config>\n<origin-ips>" + Helper.createIp() + "</origin-ips>\n </origin-config> \n" +
				"<log-option>\n<log-storage-day>" + 15 + "</log-storage-day>\n" +
				"<timezone>" + 8 + "</timezone>\n</log-option>\n" +
				"<ssl>\n<use-ssl>" + "false" + "</use-ssl>\n" +
				"<use-for-sni>" + "false" + "</use-for-sni>\n</ssl>\n" +
				"<comment>" + "domain updated via direct API request" + "</comment>\n" +
				"</domain>";
		
		DomainResponse resp;
		
		try {
			
			resp = new DomainResponse(proc.performPut(uri, body));
		} catch (Exception ex) {
			
			resp = new DomainResponse(ExceptionHandler.handleException(ex, null));
		}
		
		return resp;
	}

	

	@Override
	public DomainResponse getDomain(String domainId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public DomainHistoryResponse getDomainHistory(String domainId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainResponse getDomainHistoryRecord(String domainId,
			String recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainSummaryListResponse getDomainList() {
		// TODO Auto-generated method stub
		return null;
	}

}
