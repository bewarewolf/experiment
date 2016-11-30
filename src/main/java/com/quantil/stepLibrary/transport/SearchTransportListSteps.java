package com.quantil.stepLibrary.transport;

import com.mileweb.sdk.ServiceException;
import com.mileweb.sdk.cloudcdn.CloudCDNClient;
import com.mileweb.sdk.cloudcdn.model.DomainSummary;
import com.mileweb.sdk.cloudcdn.model.ListDomainResult;
import com.quantil.auth.APICredentials;
import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.global.Helper;
import com.quantil.service.ProjectData;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.junit.Assume;
import org.yecht.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pchelintsev on 11/18/2016.
 */
public class SearchTransportListSteps {

    static APIHdtClient client;
    static String xmlResponse="";
    static String transportId ="";
    List<String> transportList = new ArrayList<String>();
    static {
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void getTransportList() throws Exception {

        try {
            GenericResponse response = client.searchTransportList();
            xmlResponse = response.getXmlResult();

            Assert.assertTrue("Transport Summary List is empty", xmlResponse != null && !xmlResponse.isEmpty() && !xmlResponse.contains("<count>0</count>"));
        } catch (ServiceException e) {
            Assert.fail("Error was received: " + e.getMessage());
        }
    }

    @Step
    public void checkTransportListData() throws Exception {
        String targetDomain = Helper.createDomainName().replace("/","");
        String targetPort = Helper.createAccessPort();
        String transportName = Helper.createDomainName();
        String xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <transportName>"+transportName+"</transportName>" +
                "  <targetDomain>"+ targetDomain +"</targetDomain>\n" +
                "  <targetPort>"+targetPort+"</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        try {
         GenericResponse createResponse =  client.createTransport(xml);
            Matcher mOrigRules = Pattern.compile("<transportId>.*</transportId>").matcher(createResponse.getXmlResult());
            while (mOrigRules.find())
                transportId = mOrigRules.group();
         Assert.assertTrue("Transport was not created",createResponse.getXmlResult().contains("<transportId"));

            GenericResponse response = client.searchTransportList();
            xmlResponse = response.getXmlResult();
            Assert.assertTrue("Domain Summary List is empty", xmlResponse != null && !xmlResponse.isEmpty());


            if (!xmlResponse.isEmpty()) {
                Assert.assertTrue("transportId isn't presented", xmlResponse.contains(transportId));
                Assert.assertTrue("targetDomain is not equal",xmlResponse.contains(targetDomain));
                Assert.assertTrue("targetPort is not equal",xmlResponse.contains(targetPort));
                Assert.assertTrue("transportName is not equal",xmlResponse.contains(transportName));

            } else {
                Assert.fail("DB doesn't contain data for domain ID (%s) from returned Domain Summary List");
            }
        } catch (ServiceException e) {
            Assert.fail("Error was received: " + e.getMessage());
        }
    }

    @Step
    public void checkUniqueness() throws Exception {

        try {
            GenericResponse response = client.searchTransportList();
            xmlResponse = response.getXmlResult();

            Assert.assertTrue("xml responce is empty",xmlResponse != null && !xmlResponse.isEmpty() && !xmlResponse.contains("<count>0</count>"));

            Matcher mOrigRules = Pattern.compile("<transportId>\\w*</transportId>").matcher(xmlResponse);
            while (mOrigRules.find()) {
                transportId = mOrigRules.group();
                transportList.add(transportId.replace("<transportId>","").replace("</transportId>",""));
            }
           HashSet<String> out = new HashSet(transportList);
           Assert.assertTrue("Domain Summary List contains duplicates", transportList.size() == out.size());

        } catch (ServiceException e) {

            Assert.fail("Error was received: " + e.getMessage());
        }
        transportList.clear();
    }


    @Step
    public void checkSortingOrder() throws Exception {

        try {
            GenericResponse response = client.searchTransportList();
            xmlResponse = response.getXmlResult();
            Assert.assertTrue("Transport Summary List is empty", xmlResponse != null && !xmlResponse.isEmpty());

            Matcher mOrigRules = Pattern.compile("<transportId>\\w*</transportId>").matcher(xmlResponse);
            while (mOrigRules.find()) {
                transportId = mOrigRules.group();
                transportList.add(transportId.replace("<transportId>","").replace("</transportId>",""));
            }

            int prevId = Integer.parseInt(transportList.get(0));
            for (int i = 1; i < transportList.size(); i++) {
                int curId = Integer.parseInt(transportList.get(i));
                Assert.assertTrue("Sorting order is wrong", prevId < curId);
                prevId = curId;
            }
        } catch (ServiceException e) {
            Assert.fail("Error was received: " + e.getMessage());
        }
        transportList.clear();
    }


    @Step
    public void getTransportListUnsubscribedUser() throws Exception {

           APICredentials credentials = APICredentials.UnsubscribedUserHDT;
           APIHdtClient client = APIHdtClient.getClient(credentials);
        try {

            GenericResponse response = client.searchTransportList();
            xmlResponse = response.getXmlResult();

            Assert.assertTrue("Domain Summary List is not empty for unsubscribed user", xmlResponse.contains("<count>0</count>"));
        } catch (ServiceException e) {
            Assert.fail("Error was received: " + e.getMessage());
        }
    }
}
