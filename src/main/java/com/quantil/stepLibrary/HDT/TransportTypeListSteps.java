package com.quantil.stepLibrary.HDT;

import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.service.ProjectData;
import com.quantil.validation.ResponseValidator;
import junit.framework.Assert;
import net.thucydides.core.annotations.Step;

/**
 * Created by saddius on 11/24/2016.
 */
public class TransportTypeListSteps {
    static APIHdtClient client;

    static {
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void getTransportTypeList() throws TestInitializationException, ValidationException {

        GenericResponse r = client.getTransportTypeList();
        ResponseValidator.validateResponse(r);

        TestData.put("xmlResponse",r.getXmlResult());

    }

    @Step
    public void responseContain(String content) throws TestInitializationException, ValidationException {
        Assert.assertTrue(TestData.get("xmlResponse", String.class), TestData.get("xmlResponse", String.class).contains(content));
    }
}
