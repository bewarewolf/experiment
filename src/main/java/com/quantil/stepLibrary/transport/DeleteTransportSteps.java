package com.quantil.stepLibrary.transport;

import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.service.ProjectData;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

/**
 * Created by pchelintsev on 11/16/2016.
 */
public class DeleteTransportSteps {
    static APIHdtClient client;
    public static String getResponse = "";
    public static String deleteResponce ="";


    static {
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void checkTransportIsDeleted(String transportId) throws TestInitializationException, ValidationException {

        GenericResponse delResponce = client.deleteTransport(transportId);
        deleteResponce = delResponce.getXmlResult();

        Assert.assertTrue("",deleteResponce.contains("<transportId>"));
        GenericResponse response1 = client.getTransport(transportId);
        getResponse = response1.getXmlResult();
        if (!getResponse.isEmpty()) {
            Assert.assertTrue("'success' message is not returned", getResponse.contains("The specified transport id does not exist."));
        } else {
            Assert.fail(String.format("Error was received - '%s'.", getResponse));
        }

    }

    @Step
    public void checkNonExistingTransportIsDeleted(String transportId) throws TestInitializationException, ValidationException {

        GenericResponse delResponce = client.deleteTransport(transportId);
        deleteResponce = delResponce.getXmlResult();

        if (!deleteResponce.isEmpty()) {
            Assert.assertTrue("'success' message is not returned", deleteResponce.contains("The specified transport id does not exist."));
        } else {
            Assert.fail(String.format("Error was received - '%s'.", deleteResponce));
        }

    }

    @Step
    public void IsDeleted(String transportId) throws TestInitializationException, ValidationException {

        for(int i =461; i >0; i--){
            transportId = Integer.toString(i);
            GenericResponse delResponce = client.deleteTransport(transportId);
            deleteResponce = delResponce.getXmlResult();
        }


        Assert.assertTrue("",deleteResponce.contains("<transportId>"));
        GenericResponse response1 = client.getTransport(transportId);
        getResponse = response1.getXmlResult();
        if (!getResponse.isEmpty()) {
            Assert.assertTrue("'success' message is not returned", getResponse.contains("The specified transport id does not exist."));
        } else {
            Assert.fail(String.format("Error was received - '%s'.", getResponse));
        }

    }
}
