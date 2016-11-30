package com.quantil.http;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.Logger;

import com.quantil.client.response.ExceptionHandler;
import com.quantil.entities.response.GenericResponse;
import com.quantil.runners.QuantilTestRunner;


public class HttpProcessor {
    
	static Logger LOG = QuantilTestRunner.LOG;
	
    String currentDate;
    
    String endpoint;
    String user;
    String pass;
    
    public HttpProcessor(String ep, String u, String p) {
        
        this.endpoint = ep;
        this.user = u;
        this.pass = p;
    }
    
    private String createKey() throws Exception {
		
		SimpleDateFormat formatter;

		formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
		
		currentDate = formatter.format(new Date());		
		
		SecretKeySpec signingKey = new SecretKeySpec(pass.getBytes(), "HmacSHA1");

		// get an hmac_sha1 Mac instance and initialize with the signing key
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(signingKey);

		// compute the hmac on input data bytes
		byte[] rawHmac = mac.doFinal(currentDate.getBytes());
		Base64 b64 = new Base64();
		String pas = user + ":" + new String(b64.encode(rawHmac), "UTF-8");
		
		return new String(b64.encode(pas.getBytes()), "UTF-8");
	}
		
	private HttpHost hostFromURI(String strUri) throws URISyntaxException {

		URI uri = new URI(strUri);
		//    HttpHost host = new HttpHost(uri.getHost(), uri.getScheme().equals("https") ? 443 : 80, uri.getScheme());
		int port;
		if (uri.getSchemeSpecificPart().contains("hdt"))
			port = 7443;
		else if (uri.getScheme().equals("https") && !uri.getSchemeSpecificPart().contains("hdt"))
			port = 443;
		else port = 80;
		HttpHost host = new HttpHost(uri.getSchemeSpecificPart().substring(2, uri.getSchemeSpecificPart().length()),
				port, uri.getScheme());

		return host;
    }
	
	public GenericResponse performGet(String uri) {
		
		LOG.info("Performing GET request: " + uri);
		
		try {

			HttpHost target = hostFromURI(endpoint);
			
		    CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet get = new HttpGet(uri);
			
			get.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + createKey());
			get.addHeader(HttpHeaders.HOST, target.getHostName());
			get.addHeader("Date", currentDate);
			get.addHeader("Accept", "application/xml");
			
			CloseableHttpResponse resp = client.execute(target, get);
					
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			resp.getEntity().writeTo(out);
	
			int status = resp.getStatusLine().getStatusCode();
			
			GenericResponse aresp = new GenericResponse();
	
			aresp.setXmlResult(new String(out.toByteArray()));
			aresp.setStatusCode(status);
	
			return aresp;
		} catch (Exception ex) {
			LOG.error("Exception caught", ex);
			return ExceptionHandler.handleException(ex, null);
		}
	}
        
        public GenericResponse performDelete(String uri) {
		
        	LOG.info("Performing DELETE request: " + uri);
        	
        	try {
        		        	
				HttpHost target = hostFromURI(endpoint);
			    
			    CloseableHttpClient client = HttpClientBuilder.create().build();
				
				HttpDelete get = new HttpDelete(uri);
				
				get.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + createKey());
				get.addHeader(HttpHeaders.HOST, target.getHostName());
				get.addHeader("Date", currentDate);
				get.addHeader("Accept", "application/xml");
				
				CloseableHttpResponse resp = client.execute(target, get);
						
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				resp.getEntity().writeTo(out);
				
				int status = resp.getStatusLine().getStatusCode();
				
				GenericResponse aresp = new GenericResponse();
		
				aresp.setXmlResult(new String(out.toByteArray()));
				aresp.setStatusCode(status);
		                
				return aresp;
        	} catch (Exception ex) {
        		LOG.error("Exception caught", ex);
    			return ExceptionHandler.handleException(ex, null);
    		}
	}
        
        public GenericResponse performPut(String uri) {
		
        	LOG.info("Performing PUT request: " + uri);
        	
        	try { 
		
        		HttpHost target = hostFromURI(endpoint);
	   
			    CloseableHttpClient client = HttpClientBuilder.create().build();
				
				HttpPut get = new HttpPut(uri);
				
				get.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + createKey());
				get.addHeader(HttpHeaders.HOST, target.getHostName());
				get.addHeader("Date", currentDate);
				get.addHeader("Accept", "application/xml");
				
				CloseableHttpResponse resp = client.execute(target, get);
						
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				resp.getEntity().writeTo(out);
				
				int status = resp.getStatusLine().getStatusCode();
				
				GenericResponse aresp = new GenericResponse();
		
				aresp.setXmlResult(new String(out.toByteArray()));
				aresp.setStatusCode(status);
		                
				return aresp;
        	} catch (Exception ex) {
        		LOG.error("Exception caught", ex);
    			return ExceptionHandler.handleException(ex, null);
    		}	
	}
        
        public GenericResponse performPost(String uri, String body)  {
		
        	LOG.info("Performing POST request: " + uri);
        	
        	try {
		
        		HttpHost target = hostFromURI(endpoint);
	    
			    CloseableHttpClient client = HttpClientBuilder.create().build();
				
				HttpPost get = new HttpPost(uri);
				
				get.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + createKey());
				get.addHeader(HttpHeaders.HOST, target.getHostName());
				get.addHeader("Date", currentDate);
				get.addHeader("Accept", "application/xml");
		                get.addHeader("Content-Type", "application/xml");
		                
		                HttpEntity ent = new StringEntity(body);
				get.setEntity(ent);
		                
				CloseableHttpResponse resp = client.execute(target, get);
						
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				resp.getEntity().writeTo(out);
				
				int status = resp.getStatusLine().getStatusCode();
				
				GenericResponse aresp = new GenericResponse();
		
				aresp.setXmlResult(new String(out.toByteArray()));
				aresp.setStatusCode(status);
		                
				return aresp;
        	} catch (Exception ex) {
        		LOG.error("Exception caught", ex);
    			return ExceptionHandler.handleException(ex, null);
    		}
	}

	public GenericResponse performPut(String uri, String body) {

		LOG.info("Performing PUT request: " + uri);
		
		try {
		
			HttpHost target = hostFromURI(endpoint);
		
			CloseableHttpClient client = HttpClientBuilder.create().build();
	
			HttpPut put = new HttpPut(uri);
			
			put.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + createKey());
			put.addHeader(HttpHeaders.HOST, target.getHostName());
			put.addHeader("Date", currentDate);
			put.addHeader("Accept", "application/xml");
			put.addHeader("Content-Type", "application/xml");
	
			HttpEntity ent = new StringEntity(body);
			put.setEntity(ent);
	
			CloseableHttpResponse resp = client.execute(target, put);
	
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			resp.getEntity().writeTo(out);
	
			int status = resp.getStatusLine().getStatusCode();
			
			GenericResponse aresp = new GenericResponse();
	
			aresp.setXmlResult(new String(out.toByteArray()));
			aresp.setStatusCode(status);
			
			return aresp;
		} catch (Exception ex) {
			LOG.error("Exception caught", ex);
			return ExceptionHandler.handleException(ex, null);
		}
	}	
}
