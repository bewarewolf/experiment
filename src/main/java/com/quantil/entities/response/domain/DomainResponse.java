package com.quantil.entities.response.domain;

import com.mileweb.sdk.cloudcdn.model.Domain;
import com.quantil.entities.response.GenericResponse;

public class DomainResponse extends GenericResponse {

//	protected String location;
	protected String cname;
	
	private Domain domain;

	public DomainResponse() {}
	
	public DomainResponse(int statusCode, String xmlResult,
			String message, String requestId, String location, Domain domain) {
		super();
		this.statusCode = statusCode;
		this.xmlResult = xmlResult;
		this.message = message;
		this.requestId = requestId;
		this.location = location;
		this.domain = domain;
	}

	public DomainResponse(GenericResponse resp) {
		
		this.statusCode = resp.getStatusCode();
		this.xmlResult = resp.getXmlResult();
		this.message = resp.getMessage();
		this.requestId = resp.getRequestId();
		this.location = resp.getLocation();
		this.timestamp = resp.getTimestamp();
		
		if (resp.getEntity() != null && resp.getEntity() instanceof Domain) 
			this.domain = (Domain) resp.getEntity();
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
