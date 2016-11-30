package com.quantil.test;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.annotations.Title;
import com.quantil.client.http.APIBandwidthReportClient;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.service.ProjectData;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.reports.BandwidthSteps;
import com.quantil.thucydides.Features;

@RunWith(QuantilTestRunner.class)
@Story(Features.TrafficRelatedReportingServices.ReportTest.class)
public class ReportTest {

	@Steps
	GenericSteps genericSteps;

	@Steps
	BandwidthSteps bandwidthSteps;

	@Before
	public void setup() {

		TestData.init();
	}

	@Test
	@Title("Report test example")
	@Priority(value = TestPriority.P3)
	@Environment(value = EnvironmentType.QA)
	public void bandwidthAlldomainsTest() throws TestInitializationException, ValidationException {

		genericSteps.about("Let's see if the Bandwidth All domains API works",
				"Nothing to add",
				"Method doesn't take additional arguments");

		bandwidthSteps.allDomainsBandwidthReport();
	}

	@Test
	@Title("Check that old API url is removed")
	@Priority(value = TestPriority.P3)
	@Environment(value = EnvironmentType.QA)
	@Issue("Bug 123")
	public void flowAlldomainsTest() throws TestInitializationException, ValidationException {

		genericSteps.about("Let's see if the Bandwidth All domains API works",
				"dateFrom - date from",
				"dateTo - date to");

		TestData.put("dateFrom", ProjectData.dateFrom);
		TestData.put("dateTo", ProjectData.dateTo);

		bandwidthSteps.flowAlldomainsTest();
	}

	@Test
	@Title("Check that old API url is removed")
	@Priority(value = TestPriority.P3)
	@Environment(value = EnvironmentType.QA)
	@Issue("Bug 123")
	public void flowAlldomainsTest1() throws TestInitializationException, ValidationException {

		genericSteps.about("Let's see if the Bandwidth All domains API works",
				"dateFrom - date from",
				"dateTo - date to");

		TestData.put("dateFrom", ProjectData.dateFrom);
		TestData.put("dateTo", new Object());

		bandwidthSteps.flowAlldomainsTest();
	}

	@Test
	@Title("Check that old API url is removed")
	@Priority(value = TestPriority.P3)
	@Environment(value = EnvironmentType.QA)
	@Issue("Bug 123")
	public void flowAlldomainsTest2() throws TestInitializationException, ValidationException {

		genericSteps.about("Let's see if the Bandwidth All domains API works",
				"dateFrom - date from",
				"dateTo - date to");

		TestData.put("dateFrom", ProjectData.dateFrom);
		//TestData.put("dateTo", new Object());

		bandwidthSteps.flowAlldomainsTest();
	}
}
