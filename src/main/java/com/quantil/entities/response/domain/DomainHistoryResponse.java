package com.quantil.entities.response.domain;

import java.util.Date;
import java.util.List;

import com.mileweb.sdk.cloudcdn.model.Domain;
import com.mileweb.sdk.cloudcdn.model.DomainHistoryRecord;
import com.quantil.entities.response.GenericResponse;

public class DomainHistoryResponse extends GenericResponse {

	private List<DomainHistoryRecord> recordList;
	
	public DomainHistoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainHistoryResponse(int statusCode, String xmlResult,
			String message, String requestId, String location, Date timestamp, String extraInfo, List<Domain> historyList) {
		super(statusCode, xmlResult, message, requestId, location, timestamp, extraInfo);
		// TODO Auto-generated constructor stub
	}

	public DomainHistoryResponse(GenericResponse resp) {
		
		this.statusCode = resp.getStatusCode();
		this.xmlResult = resp.getXmlResult();
		this.message = resp.getMessage();
		this.requestId = resp.getRequestId();
		this.location = resp.getLocation();
		this.timestamp = resp.getTimestamp();
		this.extraInfo = resp.getExtraInfo();
	}
	
	public List<DomainHistoryRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<DomainHistoryRecord> recordList) {
		this.recordList = recordList;
	}
}
