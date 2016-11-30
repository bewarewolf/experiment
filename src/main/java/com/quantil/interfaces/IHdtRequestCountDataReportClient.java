package com.quantil.interfaces;

import com.quantil.entities.response.GenericResponse;

import java.util.Date;

/**
 * Created by saddius on 11/25/2016.
 */
public interface IHdtRequestCountDataReportClient {
    GenericResponse getRequestCountSummaryReport(Date dateFrom, Date dateTo);
    GenericResponse getRequestCountSummaryReport(Date dateFrom, Date dateTo, String interval);
    GenericResponse getTransportTypeRequestCountReport(String transportType, Date dateFrom, Date dateTo);
    GenericResponse getTransportTypeRequestCountReport(String transportType, Date dateFrom, Date dateTo, String interval);
}
