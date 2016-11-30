package com.quantil.test.HDT.TransportManagement;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.annotations.Title;
import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.Helper;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.service.ProjectData;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.transport.CreateTransportSteps;
import com.quantil.stepLibrary.transport.GetTransportSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by pchelintsev on 11/16/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.TransportManagement.GetTransportTests.class)
public class GetTransportTest {


    public static String ipportId;
    public static String vpnId;
    public static String socks5Id;


    @Steps
    GenericSteps genericSteps;

    @Steps
    GetTransportSteps getTransportSteps;

    @BeforeClass
    public static void setup() {

        TestData.init();

        //create ipport transport
        String type = "ipport";
        String targetDomain = Helper.createDomainName().replace("/","");
        String targetPort = Helper.createAccessPort();
        String xml = "<transport>\n" +
                "  <transportType>"+type+"</transportType>\n" +
                "  <targetDomain>" +targetDomain+"</targetDomain>\n" +
                "  <targetPort>"+targetPort+"</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        APIHdtClient client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);

        GenericResponse responce = client.createTransport(xml);

        String transportId = responce.getXmlResult();
        String ipportResult[] = transportId.split("<transportId>");
        String[] ipport = ipportResult[1].split("</transportId");
        ipportId = ipport[0];

        //create vpn transport
        type = "vpn";
        String userAccount = Helper.createDomainName().replace("/","");
        String userPwd = Helper.createAccessPort();
        xml = "<transport>\n" +
                "  <transportType>"+type+"</transportType>\n" +
                "  <useFtp>0</useFtp>\n" +
                "  <userAccount>"+userAccount+"</userAccount>\n" +
                "  <userPwd>"+userPwd+"</userPwd>\n" +
                "</transport>";
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
        responce = client.createTransport(xml);

        transportId = responce.getXmlResult();
        String vpnResult[] = transportId.split("<transportId>");
        String vpn[] = vpnResult[1].split("</transportId");
        vpnId = vpn[0];

        //create socks5 transport
        type = "socks5";
        userAccount = Helper.createDomainName().replace("/","");
        userPwd = Helper.createAccessPort();
        xml = "<transport>\n" +
                "  <transportType>"+type+"</transportType>\n" +
                "  <useFtp>0</useFtp>\n" +
                "  <userAccount>"+userAccount+"</userAccount>\n" +
                "  <userPwd>"+userPwd+"</userPwd>\n" +
                "</transport>";
        client = APIHdtClient.getClient(ProjectData.selectedAPIEndpoint);
        responce = client.createTransport(xml);

        transportId = responce.getXmlResult();
        String socks5Result[] = transportId.split("<transportId>");
        String socks5[] = socks5Result[1].split("</transportId");
        socks5Id = socks5[0];
    }

    @Test
    @Title("Check that transport Xml can be retrieved type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeIpport() throws Exception {

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        getTransportSteps.getTransportTypeIpport(ipportId);
    }

    @Test
    @Title("Check that transport Xml can be retrieved type vpn")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeVpn() throws Exception {

        genericSteps.about("Check that transport Xml can be retrieved with type vpn",
                "Input data: to be filled");

        getTransportSteps.getTransportTypeIpport(vpnId);
    }

    @Test
    @Title("Check that transport Xml can be retrieved type socks5")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void getTransportTypeSocks5() throws Exception {

        genericSteps.about("Check that transport Xml can be retrieved with type socks5",
                "Input data: to be filled");

        getTransportSteps.getTransportTypeIpport(socks5Id);
    }

}
