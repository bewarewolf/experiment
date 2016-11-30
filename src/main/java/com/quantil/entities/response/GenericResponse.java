package com.quantil.entities.response;


import java.util.Date;


public class GenericResponse {
	
	protected int statusCode;
	protected String xmlResult;
	protected String message;
	protected String requestId;
	protected String location;
	protected Date timestamp;
	protected String extraInfo;
	
	protected Object entity;
	
	public GenericResponse() {
		
		this.timestamp = new Date();
		this.xmlResult = new String();
		this.message = new String();
		this.requestId = new String();
		this.location = new String();
		this.extraInfo = new String();
	}
	
	public GenericResponse(int statusCode, String xmlResult,
			String message, String requestId, String location, 
			Date timestamp, String extraInfo) {
		super();
		this.statusCode = statusCode;
		this.xmlResult = xmlResult;
		this.message = message;
		this.requestId = requestId;
		this.location = location;
		this.timestamp = timestamp;
		this.extraInfo = extraInfo;
	}

	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	

	public String getXmlResult() {
		return xmlResult;
	}

	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	@Override
	public String toString() {
		
		return String.format("Timestamp: %s; Request id: %s; Status code: %d; Message: %s\r\n%s", 
				this.timestamp, 
				this.requestId, 
				this.statusCode,
				this.message,
				this.extraInfo);
	}
}
