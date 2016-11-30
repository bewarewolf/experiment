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
import com.quantil.stepLibrary.HDT.reports.TrafficVolumeSummaryReportTestSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by saddius on 11/7/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.FlowData.TransportTrafficVolumeSummaryReportTest.class)
public class TrafficVolumeSummaryReportTest {

    @Steps
    GenericSteps genericSteps;

    @Steps
    static TrafficVolumeSummaryReportTestSteps tSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Traffic Volume Summary Report without interval")
    public void getTrafficVolumeSummaryReport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Traffic Volume Summary Report without interval","Input data: to be filled");
        tSteps.prepareTestData("");
        tSteps.getTrafficVolumeSummaryReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Traffic Volume Summary Report with oneminute interval")
    public void getTrafficVolumeSummaryReportOneminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Traffic Volume Summary Report with oneminute interval","Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute");
        tSteps.getTrafficVolumeSummaryReportInterval();
        tSteps.responseContain("<flow-report>");

    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Traffic Volume Summary Report with fiveminutes interval")
    public void getTrafficVolumeSummaryReportFiveminutes() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid response is returned for Traffic Volume Summary Report with fiveminutes interval","Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes");
        tSteps.getTrafficVolumeSummaryReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Traffic Volume Summary Report with hourly interval")
    public void getTrafficVolumeSummaryReportHourly() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid response is returned for Traffic Volume Summary Report with hourly interval","Input data: to be filled");
        tSteps.prepareTestData("hourly");
        tSteps.getTrafficVolumeSummaryReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Traffic Volume Summary Report with daily interval")
    public void getTrafficVolumeSummaryReportHourlyDaily() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid response is returned for Traffic Volume Summary Report with daily interval","Input data: to be filled");
        tSteps.prepareTestData("daily");
        tSteps.getTrafficVolumeSummaryReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Traffic Volume Summary Report with monthly interval")
    public void getTrafficVolumeSummaryReportHourlyMonthly() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid response is returned for Traffic Volume Summary Report with monthly interval","Input data: to be filled");
        tSteps.prepareTestData("monthly");
        tSteps.getTrafficVolumeSummaryReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'")
    public void getTrafficVolumeSummaryReportOneDayTimeRange() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute");
        tSteps.getTrafficVolumeSummaryReportOneDayTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'")
    public void getTrafficVolumeSummaryReportFromOneDayToOneWeekTimeRange() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'",
                "Input data: to be filled");
        tSteps.prepareTestData("fiveminutes");
        tSteps.getTrafficVolumeSummaryReportOneWeekTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'")
    public void getTrafficVolumeSummaryReportFromOneWeekToOneMonthTimeRange() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly");
        tSteps.getTrafficVolumeSummaryReportMoreThanOneWeekTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'")
    public void getTrafficVolumeSummaryReportFromOneMonthTimeRange() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily");
        tSteps.getTrafficVolumeSummaryReportMoreThanMonthTimeRange();
    }

//    ------Negatives------

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Traffic Volume Summary Report with invalid interval")
    public void getTrafficVolumeSummaryReportInvalidInterval() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid error is returned for Traffic Volume Summary Report with invalid interval",
                "Input data: to be filled");
        tSteps.prepareTestData("invalid");
        tSteps.getTrafficVolumeSummaryReportInvalidInterval();
        tSteps.responseContain("The interval parameter value is invalid");
    }

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Traffic Volume Summary Report with 'dateto' parameter is higher than 'datefrom'")
    public void getTrafficVolumeSummaryReportSwappedDates() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid error is returned for Traffic Volume Summary Report with 'dateto' parameter is higher than 'datefrom'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly");
        tSteps.getTrafficVolumeSummaryReportSwappedDates();
        tSteps.responseContain("The date specified is invalid");
    }
}
