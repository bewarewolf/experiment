package com.quantil.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mileweb.sdk.cloudcdn.model.ServiceType;
import com.mileweb.sdk.cloudview.model.Timezone;
import com.quantil.auth.APICredentials;
import com.quantil.enums.EnvironmentType;

public class ProjectData {

	
    public static Date dateFrom;
    public static Date dateTo;
    public static String date = "2016-03-17";
    public static String domainId = "100006940"; //mwtrial.info  
    public static String rangeStart = "10:00";
    public static String rangeEnd = "12:00";
    public static Timezone timezone = Timezone.GMT_ADD_7;
    public static String serviceType = ServiceType.DOWNLOAD.toString();
    
     
    public static APICredentials selectedAPIEndpoint = APICredentials.HDT;
    public static EnvironmentType selectedEnvironment = EnvironmentType.HDT;

    public static APICredentials HdtAPIEndpoint = APICredentials.HDT;
    public static EnvironmentType HdtEnvironment = EnvironmentType.HDT;

    public static String mwtrialEp = "10.10.1.122";
    public static String mwtrialUser = "dev";
    public static String mwtrialPass = "devpassword!";
    public static String mwtrialLocation = "/home/dev/www/thucydides"; 
    
    public static DateFormat format;
    
    static {
    	try {
    		String envProp = System.getProperty("test.env").toUpperCase();
    		selectedEnvironment = EnvironmentType.valueOf(envProp);
    		selectedAPIEndpoint = APICredentials.valueOf(envProp);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
		format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		try {
			dateFrom = format.parse("2015-11-01 06:50:00+0200");
			dateTo = format.parse("2015-11-25 22:00:00+0200");
		} catch (ParseException e) {
			dateFrom = new Date(System.currentTimeMillis() - 1296000000);
			dateTo = new Date();
		}
    }
}
