package com.quantil.test;

import com.quantil.annotations.Priority;
import com.quantil.enums.TestPriority;
import com.quantil.global.Helper;
import com.quantil.stepLibrary.transport.CreateTransportSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Title;
import com.quantil.enums.EnvironmentType;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.reports.FlowSteps;
import com.quantil.thucydides.Features;

@RunWith(QuantilTestRunner.class)
@Story(Features.Regression.Bug_4097_Test.class)
public class Bug_4097_Test {
    public static String xml;
    public static String transportId;

	@Steps
	GenericSteps genericSteps;

	@Steps
	FlowSteps flowSteps;

    @Steps
    CreateTransportSteps createTransportSteps;

	@Before
	public void setup() {

		TestData.init();
	}

	@Test
	@Issue(value = "4097")
	@Title("Check that the same result is returned if user swaps Start and End ranges. Service type = DOWNLOAD")
	@Environment(value = EnvironmentType.QA)
	public void rangeFlowReportTest1() throws TestInitializationException, ValidationException {



		genericSteps.about("Check that the same result is returned if user swaps Start and End ranges. Service type = DOWNLOAD",
				"Input data: to be filled");

        flowSteps.prepareTestData();
		flowSteps.rangeFlowReport();
		flowSteps.swapDateRanges();
		flowSteps.rangeFlowReport();
		flowSteps.compareReportData();
	}

    @Test
    @Issue(value = "3207")
    @Title("Check that transport can be created with mandatory fields type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.QA)
    public void rangeFlowReportTest11() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that transport is created with mandatory fields with type ipport",
                "Input data: to be filled");

        xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";

        transportId =  createTransportSteps.checkTransportIsCreated(xml);
        System.out.println("test test ");

    }
}
