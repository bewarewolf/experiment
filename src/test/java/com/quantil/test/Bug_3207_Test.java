package com.quantil.test;

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
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.misc.MiscSteps;
import com.quantil.thucydides.Features;

@RunWith(QuantilTestRunner.class)
@Story(Features.Regression.Bug_3207_Test.class)
public class Bug_3207_Test {

	@Steps
	GenericSteps genericSteps;

	@Steps
	MiscSteps miscSteps;

	@Before
	public void setup() {

		TestData.init();
	}

	@Test
	@Issue(value = "3207")
	@Title("Check ability to receive Cache IPs from CNC")
	@Environment(value = EnvironmentType.QA)
	public void ipCidrTest1() throws TestInitializationException {

		genericSteps.about("Checking that '/api/report/ip-cidrs' API returns the list of IP addresses",
				"API doesn't accept input parameters");

		miscSteps.queryCIDRs();
	}
}
