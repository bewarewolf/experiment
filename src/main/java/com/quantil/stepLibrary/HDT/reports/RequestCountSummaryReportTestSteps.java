package com.quantil.stepLibrary.HDT.reports;

import com.quantil.client.http.APIHdtRequestCountDataReportClient;
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
 * Created by saddius on 11/25/2016.
 */
public class RequestCountSummaryReportTestSteps {
    static APIHdtRequestCountDataReportClient client;

    static {
        client = APIHdtRequestCountDataReportClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void prepareTestData(String interval) {

        TestData.put(TestDataKey.DATE_FROM.getValue(), ProjectData.dateFrom);
        TestData.put(TestDataKey.DATE_TO.getValue(), ProjectData.dateTo);
        TestData.put(TestDataKey.INTERVAL.getValue(), interval);
    }

    @Step
    public void prepareTestDataOneDay(String interval) {

        TestData.put(TestDataKey.DATE_FROM.getValue(), new Date(System.currentTimeMillis() - 86400000));
        TestData.put(TestDataKey.DATE_TO.getValue(),  new Date());
        TestData.put(TestDataKey.INTERVAL.getValue(), interval);
    }

    @Step
    public void getRequestCountSummaryReport() throws TestInitializationException, ValidationException {

        GenericResponse r = client.getRequestCountSummaryReport(TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(r);
        TestData.put("xmlResponse",r.getXmlResult());

    }

    @Step
    public void getRequestCountSummaryReportInterval() throws TestInitializationException, ValidationException {

        GenericResponse r = client.getRequestCountSummaryReport(TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class), TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(r);
        TestData.put("xmlResponse",r.getXmlResult());
    }

    @Step
    public void getRequestCountSummaryReportOneDayTimeRange() throws TestInitializationException, ValidationException {

        Random random = new Random();
        Date dateFrom = new Date(System.currentTimeMillis() - (random.nextInt(1000 * 60 * 60 * 24 - 1) + 1));
        GenericResponse resultDef = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Request Count summary reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getRequestCountSummaryReportOneWeekTimeRange() throws TestInitializationException, ValidationException {

        Random random = new Random();
        Date dateFrom = new Date(System.currentTimeMillis() - (random.nextInt(1000 * 60 * 60 * 24 * 6) + (1000 * 60 * 60 * 24)));
        GenericResponse resultDef = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Request Count summary reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getRequestCountSummaryReportMoreThanOneWeekTimeRange() throws TestInitializationException, ValidationException {

//        Random random = new Random();
//        Date dateFrom = new Date(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getTime());
//        dateFrom.setDate(random.nextInt(31 - TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getDate() - 7) + TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getDate() + 7);
//        dateFrom.setMonth(dateFrom.getDate() > TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getDate() ? TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getMonth() - 1 : TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getMonth());
        Date dateFrom = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 *14));

        GenericResponse resultDef = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Request Count summary reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getRequestCountSummaryReportMoreThanMonthTimeRange() throws TestInitializationException, ValidationException {

        Random random = new Random();
        Date dateFrom = new Date(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getTime());
        dateFrom.setDate(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getDate() - 1);
        dateFrom.setMonth(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class).getMonth() - 1);
        GenericResponse resultDef = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class));
        ResponseValidator.validateResponse(resultDef);
        GenericResponse resultInter = client.getRequestCountSummaryReport(dateFrom, TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
        ResponseValidator.validateResponse(resultInter);
        Assert.assertTrue("Request Count summary reports are not equal", resultDef.getXmlResult().equalsIgnoreCase(resultInter.getXmlResult()));
    }

    @Step
    public void getRequestCountSummaryReportInvalidInterval() throws TestInitializationException, ValidationException {

        GenericResponse result = client.getRequestCountSummaryReport(TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_TO.getValue(), Date.class), TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
//       ResponseValidator.validateResponse(result);
        TestData.put("xmlResponse",result.getXmlResult());

    }

    @Step
    public void getRequestCountSummaryReportSwappedDates() throws TestInitializationException, ValidationException {

        GenericResponse result = client.getRequestCountSummaryReport(TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
                TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class), TestData.get(TestDataKey.INTERVAL.getValue(), String.class));
//        ResponseValidator.validateResponse(result);
        TestData.put("xmlResponse",result.getXmlResult());
    }

    @Step
    public void responseContain(String content) throws TestInitializationException, ValidationException {
        Assert.assertTrue(TestData.get("xmlResponse", String.class), TestData.get("xmlResponse", String.class).contains(content));
    }
}
