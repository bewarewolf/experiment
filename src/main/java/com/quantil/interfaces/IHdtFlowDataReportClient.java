package com.quantil.interfaces;

import com.quantil.entities.response.GenericResponse;

import java.util.Date;

/**
 * Created by saddius on 11/24/2016.
 */
public interface IHdtFlowDataReportClient {
    GenericResponse getTrafficVolumeSummaryReport(Date dateFrom, Date dateTo);
    GenericResponse getTrafficVolumeSummaryReport(Date dateFrom, Date dateTo, String interval);
    GenericResponse getTransportTypeTrafficVolumeReport(String transportType,Date dateFrom, Date dateTo);
    GenericResponse getTransportTypeTrafficVolumeReport(String transportType,Date dateFrom, Date dateTo, String interval);
}
