package com.quantil.test.HDT.FlowData;


import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.HDT.reports.TransportTrafficVolumeReportTestSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by saddius on 11/8/2016.
 */

@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.FlowData.TransportTrafficVolumeReportTest.class)
public class TransportTrafficVolumeReportTest {

    @Steps
    static TransportTrafficVolumeReportTestSteps tSteps;

    @Steps
    GenericSteps genericSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report without interval")
    public void getTransportTrafficVolumeReport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report without interval","Input data: to be filled");
        tSteps.prepareTestData("","12"); //17
        tSteps.getTransportTrafficVolumeReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report with 'oneminute' interval")
    public void getTransportTrafficVolumeReportOneminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report with 'oneminute' interval",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","12"); //17
        tSteps.getTransportTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");

    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report with 'fiveminutes' interval")
    public void getTransportTrafficVolumeReportFiveminutes() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report with 'fiveminutes' interval",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","17"); //12
        tSteps.getTransportTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report with 'hourly' interval")
    public void getTransportTrafficVolumeReportHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report with 'hourly' interval","Input data: to be filled");
        tSteps.prepareTestData("hourly","12"); //17
        tSteps.getTransportTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");

    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report with 'daily' interval")
    public void getTransportTrafficVolumeReportDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report with 'daily' interval","Input data: to be filled");
        tSteps.prepareTestData("daily","17"); //12
        tSteps.getTransportTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report with 'monthly' interval")
    public void getTransportTrafficVolumeReportMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report with 'monthly' interval","Input data: to be filled");
        tSteps.prepareTestData("monthly","6"); //12,17
        tSteps.getTransportTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Issue("#4608")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report with multi transport Ids")
    public void getTransportTrafficVolumeReportMultiTransportIdNoInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report with multi transport Ids","Input data: to be filled");
        tSteps.prepareTestData("","6,12"); //17
        tSteps.getTransportTrafficVolumeReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Issue("#4608")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Traffic Volume Report with multi transport Ids and interval")
    public void getTransportTrafficVolumeReportMultiTransportId() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Traffic Volume Report with multi transport Ids and interval","Input data: to be filled");
        tSteps.prepareTestData("hourly","17,12"); //6
        tSteps.getTransportTrafficVolumeReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    @Title("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'")
    public void getTransportTrafficVolumeReportOneDayTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","17"); //6
        tSteps.getTransportTrafficVolumeReportOneDayTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'")
    public void getTransportTrafficVolumeReportFromOneDayToOneWeekTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","17"); //6
        tSteps.getTransportTrafficVolumeReportOneWeekTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'")
    public void getTransportTrafficVolumeReportFromOneWeekToOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","17"); //6
        tSteps.getTransportTrafficVolumeReportOneMonthTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'")
    public void getTransportTrafficVolumeReportFromOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","17"); //6
        tSteps.getTransportTrafficVolumeReportMoreThanMonthTimeRange();
    }

//    ------Negatives------

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Transport Traffic Volume Report with invalid interval")
    public void getTransportTrafficVolumeReportInvalidInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Traffic Volume Report with invalid interval",
                "Input data: to be filled");
        tSteps.prepareTestData("invalid","17"); //6
        tSteps.getTransportTrafficVolumeReportInvalidInterval();
        tSteps.responseContain("The interval parameter value is invalid");
    }

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Transport Traffic Volume Report with 'dateto' parameter is higher than 'datefrom'")
    public void getTransportTrafficVolumeReportSwappedDates() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Traffic Volume Report with 'dateto' parameter is higher than 'datefrom'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","17"); //6
        tSteps.getTransportTrafficVolumeReportSwappedDates();
        tSteps.responseContain("The date specified is invalid");
    }

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Transport Traffic Volume Report with invalid transport Id")
    public void getTransportTrafficVolumeReportInvalidTransportId() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Traffic Volume Report with invalid transport Id",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","99999");
        tSteps.getTransportTrafficVolumeReportInvalidTransportId();
        tSteps.responseContain("The specified transport id does not exist");
    }
}

