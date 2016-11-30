package com.quantil.entities.response.domain;

import java.util.Date;
import java.util.List;

import com.mileweb.sdk.cloudcdn.model.Domain;
import com.quantil.entities.response.GenericResponse;

public class DomainListResponse extends GenericResponse {

	private List<Domain> domainList;
	
	public DomainListResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainListResponse(int statusCode, String xmlResult,
			String message, String requestId, String location, Date timestamp, String extraInfo, List<Domain> historyList) {
		super(statusCode, xmlResult, message, requestId, location, timestamp, extraInfo);
		// TODO Auto-generated constructor stub
	}

	public DomainListResponse(GenericResponse resp) {
		
		this.statusCode = resp.getStatusCode();
		this.xmlResult = resp.getXmlResult();
		this.message = resp.getMessage();
		this.requestId = resp.getRequestId();
		this.location = resp.getLocation();
		this.timestamp = resp.getTimestamp();
		this.extraInfo = resp.getExtraInfo();
	}
	
	public List<Domain> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<Domain> domainList) {
		this.domainList = domainList;
	}
	
}
