package com.quantil.test.experimental;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.annotations.Title;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.experimental.model.TestStep;
import com.quantil.experimental.tests.MySqlTestReceiver;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.thucydides.Features;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

@RunWith(ThucydidesParameterizedRunner.class)
@Story(Features.TrafficRelatedReportingServices.Experiment.class)
public class ExperimentTest {

	static Logger LOG = QuantilTestRunner.LOG;

	@TestData
    public static Collection<Object[]> testData() throws Exception {

    	String conn = "jdbc:mysql://localhost:3306/quantil_tests";

    	MySqlTestReceiver cli = new MySqlTestReceiver(conn);
    	cli.connect("quantil", "quantpass");

    	List<com.quantil.experimental.model.Test> list = cli.getTests();

    	List<Object[]> out = new ArrayList<Object[]>();

    	for (int i = 0; i < list.size(); i++) {

    		Object[] o = new Object[1];
    		o[0] = list.get(i);

    		out.add(o);
    	}

    	return out;
    }


    @Steps
    public ExperimentStep steps;

    @Steps
    public GenericSteps genSteps;

    private com.quantil.experimental.model.Test test;

    public ExperimentTest(com.quantil.experimental.model.Test test) {

    	this.test = test;
    }




    @Test
    @Title("Check that old API url is removed")
	@Priority(value = TestPriority.P3)
	@Environment(value = EnvironmentType.QA)
	@Issue("Bug 123")
    public void experimentalTest()
    		throws Exception {

    	System.out.println(test.getTest_name());

    	com.quantil.global.TestData.init();

    	genSteps.about(test.getTest_description(), "Testing experimental framework", "Hope it works");

    	for (TestStep step : test.getSteps()) {

    		System.out.println(step.getStep_name());

    		com.quantil.global.TestData.setCurrentStep(step);

    		steps.run();
    	}
    }
}
