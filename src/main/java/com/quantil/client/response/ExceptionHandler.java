package com.quantil.client.response;

import java.util.Date;

import com.mileweb.sdk.ServiceException;
import com.quantil.entities.response.GenericResponse;

public class ExceptionHandler {

	public static GenericResponse handleException(Exception ex, String extraInfo) {
		
		GenericResponse resp = new GenericResponse();
		
		resp.setTimestamp(new Date());
		resp.setExtraInfo(extraInfo);
		
		if (ex instanceof ServiceException) {
			
			ServiceException e = (ServiceException) ex;
			
			resp.setStatusCode(e.getStatusCode());
			resp.setXmlResult(e.toString());
			resp.setMessage(e.getMessage());
			resp.setRequestId(e.getRequestId());
		} else {
			
			resp.setXmlResult(ex.toString());
			resp.setMessage(ex.getMessage());
			resp.setStatusCode(-1);
			resp.setRequestId("-1");
		}
		
		return resp;
	}
}
