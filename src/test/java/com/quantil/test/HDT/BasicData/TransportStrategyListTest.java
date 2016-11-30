package com.quantil.test.HDT.BasicData;

import com.quantil.annotations.*;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.HDT.TransportStrategyListSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.*;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by saddius on 11/7/2016.
 */

@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.BasicData.TransportStrategyListTest.class)
public class TransportStrategyListTest {
    @Steps
    GenericSteps genericSteps;
    @Steps
    static TransportStrategyListSteps tSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();
    }

    @Test
    @Title("Check that response is returned for the valid Transport Strategy List request")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.ANY)
    public void getTransportStrategyList() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that response is returned for the valid Transport Strategy List request");
        tSteps.getTransportStrategyList();
        tSteps.responseContain("transport-strategy-list");
    }
}
