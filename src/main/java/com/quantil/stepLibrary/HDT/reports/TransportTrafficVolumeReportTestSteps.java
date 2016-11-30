package com.quantil.stepLibrary.HDT.reports;

import com.quantil.client.http.APIHdtFlowDataReportClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.global.TestDataKey;
import com.quantil.service.ProjectData;
import com.quantil.validation.ResponseValidator;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Date;
import java.util.Random;

/**
 * Created by saddius on 11/24/2016.
 */
public class TransportTrafficVolumeReportTestSteps {
    static APIHdtFlowDataReportClient client;

    static {
        client = APIHdtFlowDataReportClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void prepareTestData(String interval, String transportId) {

        TestData.put(TestDataKey.DATE_FROM.getValue(), ProjectData.dateFrom);
        TestData.put(TestDataKey.DATE_TO.getValue(), ProjectData.dateTo);
        TestData.put(TestDataKey.INTERVAL.getValue(), interval);
        TestData.put(TestDataKey.TRANSPORT_ID.getValue(), transportId);

    }

    @Step
    public void prepareTestDataOneDay(String interval, String transportId) {

        TestData.put(TestDataKey.DATE_FROM.getValue(), new Date(System.currentTimeMillis() - 86400000));
        TestData.put(TestDataKey.DATE_TO.getValue(),  new Date());
        TestData.put(TestDataKey.INTERVAL.getValue(), interval);
        TestData.put(TestDataKey.TRANSPORT_ID.getValue(), transportId);

    }

    @Step
    public void getTransportTrafficVolumeReport() throws TestInitializationException, ValidationException {

        GenericResponse result = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(result);
        TestData.put("xmlResponse",result.getXmlResult());
    }

    @Step
    public void getTransportTrafficVolumeReportInterval() throws TestInitializationException, ValidationException {

        GenericResponse result = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(result);
        TestData.put("xmlResponse",result.getXmlResult());
    }

    @Step
    public void getTransportTrafficVolumeReportOneDayTimeRange() throws TestInitializationException, ValidationException {

        Random random = new Random();
        Date dateFrom = new Date(System.currentTimeMillis() - (random.nextInt(1000 * 60 * 60 * 24 - 1) + 1));
        GenericResponse resultDef = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Transport Traffic Volume Reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getTransportTrafficVolumeReportOneWeekTimeRange() throws TestInitializationException, ValidationException {

        Random random = new Random();
        Date dateFrom = new Date(System.currentTimeMillis() - (random.nextInt(1000 * 60 * 60 * 24 * 6) + (1000 * 60 * 60 * 24)));
        GenericResponse resultDef = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Transport Traffic Volume Reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getTransportTrafficVolumeReportOneMonthTimeRange() throws TestInitializationException, ValidationException {

        Date dateFrom = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 *14));
        GenericResponse resultDef = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Transport Traffic Volume Reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getTransportTrafficVolumeReportMoreThanMonthTimeRange() throws TestInitializationException, ValidationException {

        Random random = new Random();
        Date dateFrom = new Date(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getTime());
        dateFrom.setDate(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getDate() - 1);
        dateFrom.setMonth(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getMonth() - 1);

        GenericResponse resultDef = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                dateFrom,
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Transport Traffic Volume Reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getTransportTrafficVolumeReportInvalidInterval() throws TestInitializationException, ValidationException {

        GenericResponse result = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        TestData.put("xmlResponse",result.getXmlResult());
    }

    @Step
    public void getTransportTrafficVolumeReportSwappedDates() throws TestInitializationException, ValidationException {

        GenericResponse result = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        TestData.put("xmlResponse",result.getXmlResult());
    }

    @Step
    public void getTransportTrafficVolumeReportInvalidTransportId() throws TestInitializationException, ValidationException {

        GenericResponse result = client.getTransportTypeTrafficVolumeReport(TestData.get(TestDataKey.TRANSPORT_ID.getValue(), String.class),
                TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        TestData.put("xmlResponse",result.getXmlResult());
    }

    @Step
    public void responseContain(String content) throws TestInitializationException, ValidationException {
        Assert.assertTrue(TestData.get("xmlResponse", String.class), TestData.get("xmlResponse", String.class).contains(content));
    }
}
