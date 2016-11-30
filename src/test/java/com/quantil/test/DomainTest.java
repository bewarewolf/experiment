package com.quantil.test;

import com.mileweb.sdk.cloudcdn.model.CreateDomainResult;
import com.quantil.exceptions.ValidationException;
import com.quantil.stepLibrary.domains.*;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.annotations.Title;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.service.ProjectData;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.reports.BandwidthSteps;
import com.quantil.thucydides.Features;
import com.quantil.validation.DomainValidator;

@RunWith(QuantilTestRunner.class)
@Story(Features.WebClassDomainManagement.DomainTest.class)
public class DomainTest {

	@Steps
	GenericSteps genericSteps;

	@Steps
	ListDomainsSteps listSteps;

	@Steps
	QueryDomainSteps querySteps;

	@Steps
	EnableDisableDomainSteps enableSteps;

	@Steps
	DomainValidator validator;

	@Steps
	CreateDomainSteps createSteps;

	@Before
	public void setup() {

		TestData.init();
	}

	@Test
	@Title("Domain test example")
	@Priority(value = TestPriority.P3)
	@Environment(value = { EnvironmentType.STAGING, EnvironmentType.PRODUCTION })
	public void bandwidthAlldomainsTest() throws TestInitializationException {

		genericSteps.about("Let's see if the Bandwidth All domains API works",
				"Nothing to add",
				"Method doesn't take additional arguments");

		listSteps.randomDomain();

		enableSteps.disableDomain();

		querySteps.queryDomain();

		validator.isDisabled();

		enableSteps.enableDomain();

		querySteps.queryDomain();

		validator.isEnabled();
	}

}
