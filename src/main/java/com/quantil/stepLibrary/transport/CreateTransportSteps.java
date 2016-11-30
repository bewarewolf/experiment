package com.quantil.stepLibrary.transport;

import com.quantil.client.http.APIFlowReportClient;
import com.quantil.client.http.APIHdtClient;

import com.quantil.entities.response.GenericResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.service.ProjectData;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by pchelintsev on 11/16/2016.
 */
public class CreateTransportSteps {
    static APIHdtClient client;
    public static String xmlResponse = "";
    public static String transportId="";

    static {
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    public void deleteTransport(String transportId){
        APIHdtClient client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);

        client.deleteTransport(transportId);
    }


    @Step
    public String checkTransportIsCreated(String xml) throws TestInitializationException, ValidationException {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        Matcher mOrigRules = Pattern.compile("<transportId>(?:([^\\.]+))</transportId>").matcher(xmlResponse);
        while (mOrigRules.find())
            transportId = mOrigRules.group();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("'success' message is not returned", xmlResponse.contains("<transportId>"));
        } else {
            Assert.fail(String.format("Error was received - '%s'.", xmlResponse));
        }
        return transportId.replace("<transportId>","").replace("</transportId>","");
    }


    @Step
    public void checkErrorForTransportWithoutTransportType(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();

        if (!xmlResponse.isEmpty()) {
           Assert.assertTrue("Wrong error was received.\n",
                   xmlResponse.contains("The transportType parameter is missing."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithInvalidTransportType(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();

        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n",
                    xmlResponse.contains("The specified transport type does not exist."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithoutTargetDomainTypeIpport(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The targetDomain parameter is missing."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithoutTargetPortTypeIpport(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The targetPort parameter is missing"));
        } else {

            Assert.fail("No errors received for request without Target Domain");
        }
    }


    @Step
    public void checkErrorForTransportWithoutUseFtpTypeIpport(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
           Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The useFtp parameter is missing"));
        } else {
           Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithInvalidUseFtpTypeIpport(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The useFtp parameter value is invalid."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithoutUseFtpTypeVpn(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The useFtp parameter is missing"));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithInvalidUseFtpTypeVpn(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The useFtp parameter value is invalid."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithoutUserPwdTypeVpn(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
           Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The userPwd parameter is missing."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithInvalidUserPwdTypeVpn(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The user password is longer than 128 characters."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithoutUserAccountTypeVpn(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The userAccount parameter is missing"));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithInvalidUserAccountTypeVpn(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
        //            xmlResponse.contains("The user account is longer than 128 characters."));
                    xmlResponse.contains("<message>CNAME already exists."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }


    @Step
    public void checkErrorForTransportWithInvalidTargetPortTypeIpport(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The port number should be between 1 and 65535. Please enter a valid port number."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }

    @Step
    public void checkErrorForTransportWithInvalidTargetDomainTypeIpport(String xml) throws Exception {

        GenericResponse response = client.createTransport(xml);
        xmlResponse = response.getXmlResult();
        if (!xmlResponse.isEmpty()) {
            Assert.assertTrue("Wrong error was received.\n%s",
                    xmlResponse.contains("The port value is invalid."));
        } else {
            Assert.fail("No errors received for request without Target Domain");
        }
    }
}
