package com.quantil.stepLibrary.transport;

import com.mileweb.sdk.ServiceException;
import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.service.ProjectData;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

/**
 * Created by pchelintsev on 11/16/2016.
 */
public class GetTransportSteps {
    static APIHdtClient client;
    public static String xmlResponse = "";

    static {
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void getTransportTypeIpport(String transportId) throws Exception {

        try {

            GenericResponse response = client.getTransport(transportId);
            xmlResponse = response.getXmlResult();
            Assert.assertTrue("Returned XML contains wrong target domain", xmlResponse.contains("<transportId>"+transportId+"</transportId>"));
        } catch (ServiceException e) {
            Assert.fail(String.format("Error was received: %s for domain ID: ", e.getMessage()));
        }
    }
}
