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
import com.quantil.stepLibrary.HDT.reports.RequestCountSummaryReportTestSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by saddius on 11/8/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.RequestCountData.RequestCountSummaryReportTest.class)
public class RequestCountSummaryReportTest {

    @Steps
    GenericSteps genericSteps;

    @Steps
    static RequestCountSummaryReportTestSteps tSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();
    }

    @Test
    @Title("Check that valid response is returned for Request Count Summary Report without interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Request Count Summary Report without interval","Input data: to be filled");
        tSteps.prepareTestData("");
        tSteps.getRequestCountSummaryReport();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Request Count Summary Report with 'oneminute' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportOneMinute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Request Count Summary Report with 'oneminute' interval","Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute");
        tSteps.getRequestCountSummaryReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Request Count Summary Report with 'fiveminutes' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportFiveMinutes() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Request Count Summary Report with 'fiveminutes' interval","Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes");
        tSteps.getRequestCountSummaryReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Request Count Summary Report with 'hourly' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Request Count Summary Report with 'hourly' interval","Input data: to be filled");
        tSteps.prepareTestData("hourly");
        tSteps.getRequestCountSummaryReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Request Count Summary Report with 'daily' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Request Count Summary Report with 'daily' interval","Input data: to be filled");
        tSteps.prepareTestData("daily");
        tSteps.getRequestCountSummaryReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Request Count Summary Report with 'monthly' interval")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Request Count Summary Report with 'monthly' interval","Input data: to be filled");
        tSteps.prepareTestData("monthly");
        tSteps.getRequestCountSummaryReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportOneDayTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute");
        tSteps.getRequestCountSummaryReportOneDayTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportFromOneDayToOneWeekTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'",
                "Input data: to be filled");
        tSteps.prepareTestData("fiveminutes");
        tSteps.getRequestCountSummaryReportOneWeekTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportFromOneWeekToOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly");
        tSteps.getRequestCountSummaryReportMoreThanOneWeekTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportFromOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily");
        tSteps.getRequestCountSummaryReportMoreThanMonthTimeRange();
    }

//    ------Negatives------

    @Test
    @Title("Check that valid error is returned for Request Count Summary Report with invalid interval")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getRequestCountSummaryReportInvalidInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Request Count Summary Report with invalid interval",
                "Input data: to be filled");
        tSteps.prepareTestData("invalid");
        tSteps.getRequestCountSummaryReportInvalidInterval();
        tSteps.responseContain("The interval parameter value is invalid");

    }

    @Test
    @Title("Check that valid error is returned for Request Count Summary Report with 'dateto' parameter is higher than 'datefrom'")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTrafficVolumeReportSwappedDates() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Request Count Summary Report with 'dateto' parameter is higher than 'datefrom'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly");
        tSteps.getRequestCountSummaryReportSwappedDates();
        tSteps.responseContain("The date specified is invalid");
    }
}
