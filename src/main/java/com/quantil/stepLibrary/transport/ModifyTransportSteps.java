package com.quantil.stepLibrary.transport;

import com.mileweb.sdk.ServiceException;
import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.service.ProjectData;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pchelintsev on 11/17/2016.
 */
public class ModifyTransportSteps {
    static APIHdtClient client;
    String xmlResponse  ="";
    String  result = "";

    static {
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void checkParameter(String transportId, String xmlParameter, String xml,String parameter) throws Exception {

        //check that transport doesn't have the same xmlParameter
        GenericResponse response = client.getTransport(transportId);
        xmlResponse = response.getXmlResult();

        Matcher mOrigRules = Pattern.compile("<"+parameter+">.*</"+parameter+">").matcher(xmlResponse);
        while (mOrigRules.find())
            result = mOrigRules.group();

        Assert.assertFalse("Modified information is presented in transport",result.equals(xmlParameter));

        //update transport
        try {
            GenericResponse modifyResponse = client.modifyTransport(transportId, xml);
            Assert.assertTrue("Error while updating", modifyResponse.getXmlResult().contains("<transportId>"));
        }
        catch (ServiceException e)
        {
            Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
        }

        //check that transport was updated
        try {
            response = client.getTransport(transportId);
            xmlResponse = response.getXmlResult();

            mOrigRules = Pattern.compile("<"+parameter+">.*</"+parameter+">").matcher(xmlResponse);
            while (mOrigRules.find())
                result = mOrigRules.group();

            Assert.assertTrue("Transport was not updated", result.equals(xmlParameter));
        } catch (ServiceException e) {
            Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
        }
    }

    @Step
    public void checkParameterIsNotChanged(String transportId, String xmlParameter, String xml,String parameter) throws Exception {

        //check that transport doesn't have the same xmlParameter
        GenericResponse response = client.getTransport(transportId);
        xmlResponse = response.getXmlResult();

        Matcher mOrigRules = Pattern.compile("<" + parameter + ">.*</" + parameter + ">").matcher(xmlResponse);
        while (mOrigRules.find())
            result = mOrigRules.group();

        Assert.assertFalse("Modified information is presented in transport", result.equals(xmlParameter));

        //update transport
        try {
            GenericResponse modifyResponse = client.modifyTransport(transportId, xml);
            Assert.assertTrue("Error while updating", modifyResponse.getXmlResult().contains("<transportId>"));
        } catch (ServiceException e) {
            Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
        }

        //check that transport was updated
        try {
            response = client.getTransport(transportId);
            xmlResponse = response.getXmlResult();

            mOrigRules = Pattern.compile("<" + parameter + ">.*</" + parameter + ">").matcher(xmlResponse);
            while (mOrigRules.find())
                result = mOrigRules.group();

            Assert.assertFalse("Transport was updated", result.equals(xmlParameter));
        } catch (ServiceException e) {
            Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
        }
    }

}
