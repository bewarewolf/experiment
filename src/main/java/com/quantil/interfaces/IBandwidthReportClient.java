package com.quantil.interfaces;


import com.mileweb.sdk.cloudview.model.Timezone;
import com.quantil.entities.response.GenericResponse;


public interface IBandwidthReportClient {

	GenericResponse allDomainsBandwidthReport();
    GenericResponse allDomainsBandwidthReport(Timezone timezone);
}
