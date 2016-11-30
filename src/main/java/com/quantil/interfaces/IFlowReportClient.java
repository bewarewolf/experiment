package com.quantil.interfaces;

import java.util.Date;

import com.mileweb.sdk.cloudview.model.Timezone;
import com.quantil.entities.response.GenericResponse;

public interface IFlowReportClient {

	GenericResponse rangeFlowReport(String domIdOrServiceType, 
									Date dateFrom, 
									Date dateTo, 
									String rangeStart, 
									String rangeEnd, 
									Timezone tZone);
}
