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
import com.quantil.stepLibrary.HDT.reports.TransportTypeRequestCountReportTestSteps;
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
@Story(Features.HDT.RequestCountData.TransportTypeRequestCountReportTest.class)
public class TransportTypeRequestCountReportTest {

    @Steps
    GenericSteps genericSteps;

    @Steps
    static TransportTypeRequestCountReportTestSteps tSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report without interval. Transport type = 'ipport'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportIpport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report without interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestData("","ipport");
        tSteps.getTransportTypeRequestCountReport();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report without interval. Transport type = 'vpn'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportVpn() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report without interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestData("","vpn");
        tSteps.getTransportTypeRequestCountReport();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report without interval. Transport type = 'socks5'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportSocks5() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report without interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestData("","socks5");
        tSteps.getTransportTypeRequestCountReport();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'oneminute' interval. Transport type = 'ipport'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportIpportOneMinute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'oneminute' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","ipport");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'fiveminutes' interval. Transport type = 'ipport'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportIpportFiveMinutes() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'fiveminutes' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","ipport");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'hourly' interval. Transport type = 'ipport'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportIpportHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'hourly' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","ipport");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'daily' interval. Transport type = 'ipport'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportIpportDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'daily' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","ipport");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval. Transport type = 'ipport'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportIpportMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestData("monthly","ipport");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'oneminute' interval. Transport type = 'vpn'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportVpnOneMinute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'oneminute' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","vpn");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'fiveminutes' interval. Transport type = 'vpn'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportVpnFiveMinutes() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'fiveminutes' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","vpn");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'hourly' interval. Transport type = 'vpn'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportVpnHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'hourly' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","vpn");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'daily' interval. Transport type = 'vpn'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportVpnDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'daily' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","vpn");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval. Transport type = 'vpn'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportVpnMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestData("monthly","vpn");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'oneminute' interval. Transport type = 'socks5'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportSocks5OneMinute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'oneminute' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","socks5");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'fiveminutes' interval. Transport type = 'socks5'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportSocks5FiveMinutes() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'fiveminutes' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","socks5");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'hourly' interval. Transport type = 'socks5'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportSocks5Hourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'hourly' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","socks5");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'daily' interval. Transport type = 'socks5'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportSocks5Daily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'daily' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","socks5");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval. Transport type = 'socks5'")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportSocks5Monthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestData("monthly","socks5");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval and multi transport type")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportMultiTransportType() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report with 'monthly' interval and multi transport type",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","ipport,socks5");
        tSteps.getTransportTypeRequestCountReportInterval();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that valid response is returned for Transport Type Request Count Report for multi transport type")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportMultiTransportTypeNoInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Request Count Report for multi transport type",
                "Input data: to be filled");
        tSteps.prepareTestData("","ipport,socks5");
        tSteps.getTransportTypeRequestCountReport();
        tSteps.responseContain("<requests-report>");
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportOneDayTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","ipport");
        tSteps.getTransportTypeRequestCountReportOneDayTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportFromOneDayToOneWeekTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'",
                "Input data: to be filled");
        tSteps.prepareTestData("fiveminutes","ipport");
        tSteps.getTransportTypeRequestCountReportOneWeekTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportFromOneWeekToOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","ipport");
        tSteps.getTransportTypeRequestCountReportOneMonthTimeRange();
    }

    @Test
    @Title("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportFromOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","ipport");
        tSteps.getTransportTypeRequestCountReportMoreThanMonthTimeRange();
    }

//    ------Negatives------

    @Test
    @Title("Check that valid error is returned for Transport Type Request Count Report with invalid interval")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportInvalidInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Type Request Count Report with invalid interval",
                "Input data: to be filled");
        tSteps.prepareTestData("invalid","vpn");
        tSteps.getTransportTypeRequestCountReportInvalidInterval();
        tSteps.responseContain("The interval parameter value is invalid");

    }

    @Test
    @Title("Check that valid error is returned for Transport Type Request Count Report with 'dateto' parameter is higher than 'datefrom'")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportSwappedDates() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Type Request Count Report with 'dateto' parameter is higher than 'datefrom'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","ipport");
        tSteps.getTransportTypeRequestCountReportSwappedDates();
        tSteps.responseContain("The date specified is invalid");

    }

    @Test
    @Title("Check that valid error is returned for Transport Type Request Count Report with invalid transport Type")
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeRequestCountReportInvalidTransportType() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Type Request Count Report with invalid transport Type",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","invalid");
        tSteps.getTransportTypeRequestCountReportInvalidTransportType();
        tSteps.responseContain("The specified transport type does not exist");
    }
}

