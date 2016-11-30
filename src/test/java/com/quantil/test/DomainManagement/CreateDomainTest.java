package com.quantil.test.DomainManagement;

/**
 * Created by saddius on 10/11/2016.
 */
import com.mileweb.sdk.cloudcdn.model.Domain;
import com.quantil.client.sdk.SDKDomainClient;
import com.quantil.exceptions.ValidationException;
import com.quantil.stepLibrary.domains.*;

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
import com.quantil.thucydides.Features;
import com.quantil.validation.DomainValidator;

@RunWith(QuantilTestRunner.class)
@Story(Features.WebClassDomainManagement.DomainTest.class)
public class CreateDomainTest {
    public static Domain domain;
    static SDKDomainClient client = SDKDomainClient.getClient(ProjectData.selectedAPIEndpoint);

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
    public void setup() throws TestInitializationException, ValidationException, InterruptedException {

        TestData.init();
        createSteps.beforeStep();
//        domain = Helper.createDomain(ServiceType.WEB, "euna");
//
//        DomainResponse resultDomain = client.createDomain(domain);
//        String domainId = resultDomain.getLocation().substring(resultDomain.getLocation().lastIndexOf("/") + 1);
//        domain.setDomainId(domainId);
//
//        TestData.put(TestDataKey.DOMAIN.toString(), domain);
//        TestData.put(TestDataKey.DOMAIN_ID.toString(), domainId);
    }

    @Test
    @Title("Check that domain can be created when only mandatory fields are present in request body")
    @Priority(value = TestPriority.P1)
    @Environment(value = { EnvironmentType.PRODUCTION, EnvironmentType.QA2 })
    public void createDomain() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that domain can be created when only mandatory fields are present in request body","Individual domain is created for this test");
        createSteps.createDomainMandatoryFields();
    }

    @Test
    @Title("Create domain - check structure of DB record")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void checkDomain() throws TestInitializationException, ValidationException {
        genericSteps.about("Check the structure of DB record","This test uses domain from setup step");
        createSteps.checkDomain();
    }

    @Test
    @Title("Check that after domain creation Log Option is correctly stored")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void checkLogOption() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that after domain creation Log Option is correctly stored","This test uses domain from setup step");
        createSteps.checkLogOption();
    }

    @Test
    @Title("Check that after domain creation Origin Config is correctly stored")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void checkOriginConfig() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that after domain creation Origin Config is correctly stored","This test uses domain from setup step");
        createSteps.checkOriginConfig();
    }

    @Test
    @Title("Check that after domain creation Cache Behavior is correctly stored")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void checkCacheBehavior() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that after domain creation Cache Behavior is correctly stored","This test uses domain from setup step");
        createSteps.checkCacheBehavior();
    }

//    @Test
//    @Title("Check that domain can't be created with unsubscribed service type")
//    @Priority(value = TestPriority.P2)
//    @Environment(value = EnvironmentType.ANY)
//    public void createDomainServiceTypeNotSubscribed() throws Exception {
//
//        Domain old = domain;
//        domain = Helper.createDomain(ServiceType.WEB, "euna");
//        tSteps.createDomainServiceTypeNotSubscribed();
//        domain = old;
//    }

    @Test
    @Title("Check that after domain creation Visit Control Rules are correctly stored")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void checkVisitControlRules() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that after domain creation Visit Control Rules are correctly stored","This test uses domain from setup step");
        createSteps.checkVisitControlRules();
    }

    @Test
    @Title("Check that domain can't be created with existing domain name")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void createExistingDomain() throws TestInitializationException, ValidationException {


        genericSteps.about("Check that domain can't be created with existing domain name","Individual domain is created for this test", "Attempt to create the domain again with the same name");
        listSteps.randomDomain();
        createSteps.createExistingDomain();
    }

    @Test
    @Title("Check that after domain creation Service Areas are correctly stored")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void checkServiceAreas() throws Exception {

        genericSteps.about("Check that after domain creation Service Areas are correctly stored", "This test uses domain from setup step");
        createSteps.checkServiceAreas();
    }

    @Test
    @Title("Check that after domain creation Client Control Rule is correctly stored")
    @Priority(value = TestPriority.P2)
    @Environment(value = EnvironmentType.ANY)
    public void checkClientControlRule() throws Exception {

        genericSteps.about("Check that after domain creation Client Control Rule is correctly stored", "This test uses download domain from setup step");
        createSteps.checkClientControlRule();
    }
}
