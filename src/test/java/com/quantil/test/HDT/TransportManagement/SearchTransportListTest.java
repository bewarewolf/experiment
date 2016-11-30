package com.quantil.test.HDT.TransportManagement;

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
import com.quantil.stepLibrary.transport.SearchTransportListSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by pchelintsev on 11/18/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.TransportManagement.SearchTransportListTests.class)
public class SearchTransportListTest {

    @Steps
    GenericSteps genericSteps;

    @Steps
    SearchTransportListSteps searchTransportListSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();
    }

    @Test
    @Title("Check that response is returned for the valid search Transport List request")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportList() throws Exception {

        genericSteps.about("Check that response is returned for the valid search Transport List request",
                "Input data: to be filled");

        searchTransportListSteps.getTransportList();
    }

    @Test
    @Title("search transport list - check that transport values are similar with created transport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportListData() throws Exception {

        genericSteps.about("search transport list - check that transport values are similar with created transport",
                "Input data: to be filled");

        searchTransportListSteps.checkTransportListData();
    }

    @Test
    @Title("Check that all domains are unique in response")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkUniqueness() throws Exception {

        genericSteps.about("Check that all domains are unique in response",
                "Input data: to be filled");

        searchTransportListSteps.checkUniqueness();
    }

    @Test
    @Title("search transport list - check that transport values are similar with created transport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkSortingOrder() throws Exception {
        genericSteps.about("search transport list - check that transport values are similar with created transport",
                "Input data: to be filled");

        searchTransportListSteps.checkSortingOrder();
    }

    @Test
    @Title("search transport list - check that transport values are similar with created transport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportListUnsubscribedUser() throws Exception {
        genericSteps.about("search transport list - check that transport values are similar with created transport",
                "Input data: to be filled");

        searchTransportListSteps.getTransportListUnsubscribedUser();
    }

}


