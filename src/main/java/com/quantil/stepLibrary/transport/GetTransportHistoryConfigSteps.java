package com.quantil.stepLibrary.transport;

import com.mileweb.sdk.ServiceException;
import com.mileweb.sdk.cloudcdn.model.GetDomainHistoryResult;
import com.quantil.auth.APICredentials;
import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.service.ProjectData;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

/**
 * Created by pchelintsev on 11/21/2016.
 */
public class GetTransportHistoryConfigSteps {
    static APIHdtClient client;
    public static String xmlResponse = "";

    static {
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void getTransportHistoryConfiguration(String transportId, Boolean isFirstUpdate) throws Exception {


       if(isFirstUpdate){
           try {

               GenericResponse response = client.getTransportHistoryConfiguration(transportId);
               xmlResponse = response.getXmlResult();
               Assert.assertTrue("Returned XML contains wrong deploys count", xmlResponse.contains("<count>1</count>"));
           } catch (ServiceException e) {
               Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
           }
       }
        else {
           try {

               GenericResponse response = client.getTransportHistoryConfiguration(transportId);
               xmlResponse = response.getXmlResult();
               Assert.assertTrue("Returned XML contains wrong deploys count", xmlResponse.contains("<count>2</count>"));
           } catch (ServiceException e) {
               Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
           }
       }
    }

    @Step
    public void getTransportHistoryConfigurationAfterUpdate(String transportId) throws Exception {

        String xml = "<transport>\n" +
                "<useFtp>1</useFtp>\n" +
                "</transport>";

        GenericResponse modifyResponse = client.modifyTransport(transportId, xml);
        Assert.assertTrue("Error while updating", modifyResponse.getXmlResult().contains("<transportId>"));

        try {
            GenericResponse response = client.getTransportHistoryConfiguration(transportId);
            xmlResponse = response.getXmlResult();
            Assert.assertTrue("Returned XML contains wrong deploys count", xmlResponse.contains("<count>2</count>"));
        } catch (ServiceException e) {
            Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
        }
    }


    @Step
    public void getTransportHistoryConfigurationInvalidTransport() throws Exception {
        String transportId = "99999";
        try {
            GenericResponse response = client.getTransportHistoryConfiguration(transportId);
            xmlResponse = response.getXmlResult();
            Assert.assertTrue(String.format("Wrong error code for domain ID: %s", transportId), xmlResponse.contains("The specified transport id does not exist."));
        }
        catch (ServiceException ex) {
           Assert.fail(String.format(" Request failed with error: %s", ex.getErrorCode(), transportId));
        }
    }

    @Step
    public void getTransportHistoryConfigurationAnotherCustomer(String transportId) throws Exception {

        APICredentials credentials = APICredentials.UnsubscribedUserHDT;
        APIHdtClient client = APIHdtClient.getClient(credentials);

        try {
            GenericResponse response = client.getTransportHistoryConfiguration(transportId);
            xmlResponse = response.getXmlResult();
            Assert.assertTrue(String.format("Wrong error code for domain ID: %s", transportId), xmlResponse.contains("This user is not allowed to perform this request."));
        }
        catch (ServiceException ex) {
            Assert.fail(String.format(" Request failed with error: %s", ex.getErrorCode(), transportId));
        }
    }
}
