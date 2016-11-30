package com.quantil.client.http;

import com.quantil.auth.APICredentials;
import com.quantil.entities.response.GenericResponse;
import com.quantil.http.HttpProcessor;
import com.quantil.interfaces.IHdtRequestCountDataReportClient;
import com.quantil.runners.QuantilTestRunner;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by saddius on 11/25/2016.
 */
public class APIHdtRequestCountDataReportClient implements IHdtRequestCountDataReportClient {
    static Logger LOG = QuantilTestRunner.LOG;
    HttpProcessor proc;
    private static APIHdtRequestCountDataReportClient exec;
    private static APICredentials current;

    private APIHdtRequestCountDataReportClient(APICredentials cred) throws Exception {


        LOG.info("Initializing API HDT Flow Data Report client");
        proc = new HttpProcessor(cred.getEndpoint(), cred.getUser(), cred.getKey());
    }

    public static APIHdtRequestCountDataReportClient getClient(APICredentials cred) {

        if (exec == null || current != cred) {

            try {
                exec = new APIHdtRequestCountDataReportClient(cred);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                LOG.error(e);
                throw new RuntimeException(e);
            }
            current = cred;
        }

        return exec;
    }

    @Override
    public GenericResponse getRequestCountSummaryReport(Date dateFrom, Date dateTo) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        String uri = String.format("/hdt/report/requests?datefrom=%s&dateto=%s",
                formatter.format(dateFrom),
                formatter.format(dateTo)).replaceAll("\\+", "%2B");

        return proc.performGet(uri);
    }

    @Override
    public GenericResponse getRequestCountSummaryReport(Date dateFrom, Date dateTo, String interval) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        String uri = String.format("/hdt/report/requests?datefrom=%s&dateto=%s&interval=%s",
                formatter.format(dateFrom),
                formatter.format(dateTo), interval).replaceAll("\\+", "%2B");

        return proc.performGet(uri);
    }

    @Override
    public GenericResponse getTransportTypeRequestCountReport(String transportType, Date dateFrom, Date dateTo) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        String uri = String.format("/hdt/report/%s/requests?datefrom=%s&dateto=%s",
                transportType,
                formatter.format(dateFrom),
                formatter.format(dateTo)).replaceAll("\\+", "%2B");

        return proc.performGet(uri);
    }

    @Override
    public GenericResponse getTransportTypeRequestCountReport(String transportType, Date dateFrom, Date dateTo, String interval) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        String uri = String.format("/hdt/report/%s/requests?datefrom=%s&dateto=%s&interval=%s",
                transportType,
                formatter.format(dateFrom),
                formatter.format(dateTo), interval).replaceAll("\\+", "%2B");

        return proc.performGet(uri);
    }
}
