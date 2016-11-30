package com.quantil.test.HDT.RequestCountData;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.HDT.reports.TransportRequestCountReportSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by saddius on 11/8/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.RequestCountData.TransportRequestCountReportTest.class)
public class TransportRequestCountReport {

    @Steps
    GenericSteps genericSteps;

    @Steps
    static TransportRequestCountReportSteps tSteps;

    @BeforeClass
    public static void setup()  {

        TestData.init();
    }

    @Test
    @Title("Check that valid response is returned for Transport Request Count Report without interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report without interval", "Input data: to be filled");
        tSteps.prepareTestData("","12");// 6, 17
        tSteps.getTransportRequestCountReport();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Request Count Report with 'oneminute' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportOneMinute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report with 'oneminute' interval", "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","12");// 6, 17
        tSteps.getTransportRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Request Count Report with 'fiveminutes' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportFiveMinutes() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report with 'fiveminutes' interval", "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","12");// 6, 17
        tSteps.getTransportRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Request Count Report with 'hourly' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report with 'hourly' interval", "Input data: to be filled");
        tSteps.prepareTestData("hourly","12");// 6, 17
        tSteps.getTransportRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Request Count Report with 'daily' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report with 'daily' interval", "Input data: to be filled");
        tSteps.prepareTestData("daily","12");// 6, 17
        tSteps.getTransportRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Request Count Report with 'monthly' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report with 'monthly' interval", "Input data: to be filled");
        tSteps.prepareTestData("monthly","12");// 6, 17
        tSteps.getTransportRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Issue("#4608")
    @Title("Check that valid response is returned for Transport Request Count Report with 'hourly' interval and multi transport Id")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportMultiTransportIdWithInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report with 'hourly' interval and multi transport Id",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","12,6");// 6, 17
        tSteps.getTransportRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Issue("#4608")
    @Title("Check that valid response is returned for Transport Request Count Report for multi transport Id without specified interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportMultiTransportIdNoInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Request Count Report for multi transport Id without specified interval",
                "Input data: to be filled");
        tSteps.prepareTestData("","6,17");// 6, 17
        tSteps.getTransportRequestCountReport();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportOneDayTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","17");// 6, 17
        tSteps.getTransportRequestCountReportOneDayTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportFromOneDayToOneWeekTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'",
                "Input data: to be filled");
        tSteps.prepareTestData("fiveminutes","17");// 6, 17
        tSteps.getTransportRequestCountReportOneWeekTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportFromOneWeekToOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","17");// 6, 17
        tSteps.getTransportRequestCountReportOneMonthTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportFromOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","17");// 6, 17
        tSteps.getTransportRequestCountReportMoreThanMonthTimeRange();
    }

//------Negatives------

    @Test
    @Title("Check that valid error is returned for Transport Request Count Report with invalid interval")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportInvalidInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Request Count Report with invalid interval",
                "Input data: to be filled");
        tSteps.prepareTestData("invalid","17");// 6, 17
        tSteps.getTransportRequestCountReportInvalidInterval();
        tSteps.responseContain("The interval parameter value is invalid");

    }

    @Test
    @Title("Check that valid error is returned for Transport Request Count Report with 'dateto' parameter is higher than 'datefrom'")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportSwappedDates() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Request Count Report with 'dateto' parameter is higher than 'datefrom'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","17");// 6, 17
        tSteps.getTransportRequestCountReportSwappedDates();
        tSteps.responseContain("The date specified is invalid");
    }

    @Test
    @Title("Check that valid error is returned for Transport Request Count Report with invalid transport Id")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportRequestCountReportInvalidTransportId() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Request Count Report with invalid transport Id",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","99999");// 6, 17
        tSteps.getTransportRequestCountReportInvalidTransportId();
        tSteps.responseContain("The specified transport id does not exist");

    }
}
