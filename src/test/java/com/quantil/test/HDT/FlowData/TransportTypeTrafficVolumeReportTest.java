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
import com.quantil.stepLibrary.HDT.reports.TransportTypeTrafficVolumeReportTestSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by saddius on 11/7/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.FlowData.TransportTypeTrafficVolumeReportTest.class)
public class TransportTypeTrafficVolumeReportTest {

    @Steps
    static TransportTypeTrafficVolumeReportTestSteps tSteps;

    @Steps
    GenericSteps genericSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report without interval. Transport type = 'ipport'")
    public void getTransportTypeTrafficVolumeReportIpport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report without interval. Transport type = 'ipport'","Input data: to be filled");
        tSteps.prepareTestData("","ipport");
        tSteps.getTransportTypeTrafficVolumeReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report without interval. Transport type = 'vpn'")
    public void getTransportTypeTrafficVolumeReportVpn() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report without interval. Transport type = 'vpn'","Input data: to be filled");
        tSteps.prepareTestData("","vpn");
        tSteps.getTransportTypeTrafficVolumeReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report without interval. Transport type = 'socks5'")
    public void getTransportTypeTrafficVolumeReportSocks5() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report without interval. Transport type = 'socks5'","Input data: to be filled");
        tSteps.prepareTestData("","socks5");
        tSteps.getTransportTypeTrafficVolumeReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'oneminute' interval. Transport type = 'ipport'")
    public void getTransportTypeTrafficVolumeReportIpportOneminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'oneminute' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","ipport");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");

    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'fiveminutes' interval. Transport type = 'ipport'")
    public void getTransportTypeTrafficVolumeReportIpportFiveminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'fiveminutes' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","ipport");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'hourly' interval. Transport type = 'ipport'")
    public void getTransportTypeTrafficVolumeReportIpportHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'hourly' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","ipport");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'daily' interval. Transport type = 'ipport'")
    public void getTransportTypeTrafficVolumeReportIpportDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'daily' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","ipport");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'monthly' interval. Transport type = 'ipport'")
    public void getTransportTypeTrafficVolumeReportIpportMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'monthly' interval. Transport type = 'ipport'",
                "Input data: to be filled");
        tSteps.prepareTestData("monthly","ipport");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'oneminute' interval. Transport type = 'vpn'")
    public void getTransportTypeTrafficVolumeReportVpnOneminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'oneminute' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","vpn");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'fiveminutes' interval. Transport type = 'vpn'")
    public void getTransportTypeTrafficVolumeReportVpnFiveminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'fiveminutes' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","vpn");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'hourly' interval. Transport type = 'vpn'")
    public void getTransportTypeTrafficVolumeReportVpnHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'hourly' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","vpn");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'daily' interval. Transport type = 'vpn'")
    public void getTransportTypeTrafficVolumeReportVpnDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'daily' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","vpn");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'monthly' interval. Transport type = 'vpn'")
    public void getTransportTypeTrafficVolumeReportVpnMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'monthly' interval. Transport type = 'vpn'",
                "Input data: to be filled");
        tSteps.prepareTestData("monthly","vpn");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'oneminute' interval. Transport type = 'socks5'")
    public void getTransportTypeTrafficVolumeReportSocksOneminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'oneminute' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","socks5");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'fiveminutes' interval. Transport type = 'socks5'")
    public void getTransportTypeTrafficVolumeReportSocksFiveminute() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'fiveminutes' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("fiveminutes","socks5");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'hourly' interval. Transport type = 'socks5'")
    public void getTransportTypeTrafficVolumeReportSocksHourly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'hourly' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","socks5");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'daily' interval. Transport type = 'socks5'")
    public void getTransportTypeTrafficVolumeReportSocksDaily() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'daily' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","socks5");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with 'monthly' interval. Transport type = 'socks5'")
    public void getTransportTypeTrafficVolumeReportSocksMonthly() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with 'monthly' interval. Transport type = 'socks5'",
                "Input data: to be filled");
        tSteps.prepareTestData("monthly","socks5");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Issue("#4608")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with multi transport types")
    public void getTransportTypeTrafficVolumeReportMultiTransportTypeNoInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with multi transport types",
                "Input data: to be filled");
        tSteps.prepareTestData("","ipport,socks5");
        tSteps.getTransportTypeTrafficVolumeReport();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Issue("#4608")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid response is returned for Transport Type Traffic Volume Report with multi transport types and interval")
    public void getTransportTypeTrafficVolumeReportMultiTransportTypeInterval() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Transport Type Traffic Volume Report with multi transport types and interval",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","ipport,vpn");
        tSteps.getTransportTypeTrafficVolumeReportInterval();
        tSteps.responseContain("<flow-report>");
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'")
    public void getTransportTypeTrafficVolumeReportOneDayTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is less than or equal one day the response interval is 'oneminute'",
                "Input data: to be filled");
        tSteps.prepareTestDataOneDay("oneminute","ipport");
        tSteps.getTransportTypeTrafficVolumeReportOneDayTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'")
    public void getTransportTypeTrafficVolumeReportFromOneDayToOneWeekTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one day and less than or equal one week the response interval is 'fiveminutes'",
                "Input data: to be filled");
        tSteps.prepareTestData("fiveminutes","ipport");
        tSteps.getTransportTypeTrafficVolumeReportOneWeekTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'")
    public void getTransportTypeTrafficVolumeReportFromOneWeekToOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one week and less than or equal one month the response interval is 'hourly'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","ipport");
        tSteps.getTransportTypeTrafficVolumeReportOneMonthTimeRange();
    }

    @Test
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'")
    public void getTransportTypeTrafficVolumeReportFromOneMonthTimeRange() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that if the time range of datefrom and dateto is more than one month the response interval is 'daily'",
                "Input data: to be filled");
        tSteps.prepareTestData("daily","ipport");
        tSteps.getTransportTypeTrafficVolumeReportMoreThanMonthTimeRange();
    }

//    ------Negatives------

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Transport Type Traffic Volume Report with invalid interval")
    public void getTransportTypeTrafficVolumeReportInvalidInterval() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid error is returned for Transport Type Traffic Volume Report with invalid interval",
                "Input data: to be filled");
        tSteps.prepareTestData("invalid","ipport");
        tSteps.getTransportTypeTrafficVolumeReportInvalidInterval();
        tSteps.responseContain("The interval parameter value is invalid");

    }

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Transport Type Traffic Volume Report with 'dateto' parameter is higher than 'datefrom'")
    public void getTransportTypeTrafficVolumeReportSwappedDates() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid error is returned for Transport Type Traffic Volume Report with 'dateto' parameter is higher than 'datefrom'",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","ipport");
        tSteps.getTransportTypeTrafficVolumeReportSwappedDates();
        tSteps.responseContain("The date specified is invalid");

    }

    @Test
    @Priority(value = TestPriority.P3)
    @Environment(value = EnvironmentType.HDT)
    @Title("Check that valid error is returned for Transport Type Traffic Volume Report with invalid transport type")
    public void getTransportTypeTrafficVolumeReportInvalidTransportType() throws TestInitializationException, ValidationException {
        genericSteps.about("Check that valid error is returned for Transport Type Traffic Volume Report with invalid transport type",
                "Input data: to be filled");
        tSteps.prepareTestData("hourly","invalid");
        tSteps.getTransportTypeTrafficVolumeReportInvalidTransportType();
        tSteps.responseContain("The specified transport type does not exist");

    }
}
