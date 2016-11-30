package com.quantil.client.response;


import java.util.Date;

import com.mileweb.sdk.BizResult;
import com.mileweb.sdk.cloudcdn.model.CreateDomainResult;
import com.mileweb.sdk.maa.app.model.http.CreateResult;
import com.quantil.entities.response.GenericResponse;

public  class SDKResponseHandler {
	
	public static GenericResponse handleResponse(BizResult in) throws Exception {
		
		GenericResponse resp = new GenericResponse();
		
		resp.setTimestamp(new Date());
		
		resp.setStatusCode(in.getStatusCode());
		resp.setXmlResult(in.getXmlResult());
		resp.setMessage(in.getMessage());
		resp.setRequestId(in.getRequestId());	
		
		/*
		java.lang.reflect.Method get;		
		
		get = in.getClass().getMethod("getStatusCode");
		resp.setStatusCode((int) get.invoke(in));
		
		get = in.getClass().getMethod("getXmlResult");
		resp.setXmlResult((String) get.invoke(in));
		
		get = in.getClass().getMethod("getMessage");
		resp.setMessage((String) get.invoke(in));
		
		get = in.getClass().getMethod("getRequestId");
		resp.setRequestId((String) get.invoke(in));		*/
		
		if (in instanceof CreateDomainResult || 
				in instanceof CreateResult) {
			
			java.lang.reflect.Method get;
			get = in.getClass().getMethod("getLocation");
			
			resp.setLocation((String) get.invoke(in));
		} 
		
		return resp;
	}
}
