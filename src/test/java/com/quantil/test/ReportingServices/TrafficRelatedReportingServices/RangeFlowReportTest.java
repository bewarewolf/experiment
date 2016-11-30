package com.quantil.test.ReportingServices.TrafficRelatedReportingServices;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.annotations.Title;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.domains.ListDomainsSteps;
import com.quantil.stepLibrary.reports.FlowSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by saddius on 9/20/2016.
 */

@RunWith(QuantilTestRunner.class)
@Story(Features.TrafficRelatedReportingServices.RangeFlowReport.class)
public class RangeFlowReportTest {

    @Steps
    GenericSteps genericSteps;

    @Steps
    FlowSteps flowSteps;

    @Steps
    ListDomainsSteps listDomains;

    @Before
    public void setup() {

        TestData.init();
    }

    @Test
    @Title("Check that valid response is returned for Range Flow request with specified date range")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.QA)
    public void getRangeFlowReport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Range Flow request with specified date range",
                "Input data: to be filled");

        flowSteps.prepareTestData();
        flowSteps.getRangeFlowReport();
        flowSteps.responseContain("reports");
    }

    @Test
    @Pending
    @Title("Check that valid response is returned for Range Flow request with specified date range")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.QA)
    public void getRangeFlowReportWithFractions() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that valid response is returned for Range Flow request with specified date range",
                "Input data: to be filled");

        flowSteps.prepareTestData();
        flowSteps.getRangeFlowReportWithFractions();
        flowSteps.responseContain("reports");
    }

    @Test
    @Title("Check that valid response is returned for Range Flow request with specified date range and domain")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.QA)
    public void getRangeFlowReportDomainId() throws Exception {

        genericSteps.about("Check that valid response is returned for Range Flow request with specified date range and domain",
                "Input data: to be filled");
        flowSteps.prepareTestData();
        listDomains.randomDomain();
        flowSteps.getDomainRangeFlowReport();
        flowSteps.responseContain("reports");
    }

//    @Test
//    @Title("Check that valid response is returned for Range Flow request with specified date range and domain")
//    @Priority(value = TestPriority.P2)
//    @Environment(value = EnvironmentType.ANY)
//    public void compareRangeFlowReportWeekAnd7Days() throws Exception {
//
//        genericSteps.about("Check that time range traffic for week is equal to summary traffic for 7 days",
//                "Input data: to be filled");
//        flowSteps.prepareTestData();
//        listDomains.randomDomain();
//        flowSteps.compareRangeFlowReportWeekAnd7Days();
//    }
}
