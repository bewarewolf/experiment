package com.quantil.test.HDT.TransportManagement;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.annotations.Title;
import com.quantil.client.http.APIHdtClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.enums.EnvironmentType;
import com.quantil.enums.TestPriority;
import com.quantil.global.Helper;
import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.service.ProjectData;
import com.quantil.stepLibrary.GenericSteps;
import com.quantil.stepLibrary.transport.ModifyTransportConfigurationSteps;
import com.quantil.stepLibrary.transport.ModifyTransportSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by pchelintsev on 11/21/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.TransportManagement.ModifyTransportConfigurationTests.class)
public class ModifyTransportConfigurationTest {

    public static String ipportId;
    public static String vpnId;
    public static String socks5Id;
    public static String xml="";
    public static String xmlParameter="";
    public static String tag="";
    @Steps
    GenericSteps genericSteps;

    @Steps
    ModifyTransportConfigurationSteps modifyTransportConfigurationSteps;

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
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkSpeedLimit() throws Exception {

        tag = "speedLimit";
        xmlParameter = "<speedLimit>1</speedLimit>";
        xml = "<transport>\n" +
                "<useFtp>1</useFtp>\n" +
                 xmlParameter + "\n" +
//                "<concurrentLimit>30</concurrentLimit>"+
//                "<transportStrategy>topspeed</transportStrategy>\n"+
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportConfigurationSteps.checkParameter(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkConcurrentLimit() throws Exception {

        tag = "concurrentLimit";
        xmlParameter = "<concurrentLimit>50</concurrentLimit>";
        xml = "<transport>\n" +
                "<useFtp>1</useFtp>\n" +
                "<speedLimit>10</speedLimit>\n" +
                "<transportStrategy>topspeed</transportStrategy>\n"+
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportConfigurationSteps.checkParameter(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportStrategy() throws Exception {

        tag = "transportStrategy";
        xmlParameter = "<transportStrategy>uniform</transportStrategy>";
        xml = "<transport>\n" +
                "<useFtp>1</useFtp>\n" +
                 xmlParameter + "\n" +
                "<speedLimit>10</speedLimit>\n" +
                "<concurrentLimit>30</concurrentLimit>"+
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportConfigurationSteps.checkParameter(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForInvalidSpeedLimit() throws Exception {

        tag = "speedLimit";
        xmlParameter = "<speedLimit>invalid</speedLimit>";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
//                "<concurrentLimit>30</concurrentLimit>"+
//                "<transportStrategy>topspeed</transportStrategy>\n"+
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportConfigurationSteps.checkErrorForInvalidSpeedLimit(ipportId,xml);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForSpeedLimitNotInRange() throws Exception {

        tag = "speedLimit";
        xmlParameter = "<speedLimit>1001</speedLimit>";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
//                "<concurrentLimit>30</concurrentLimit>"+
//                "<transportStrategy>topspeed</transportStrategy>\n"+
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportConfigurationSteps.checkErrorForInvalidSpeedLimit(ipportId,xml);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForInvalidTransportStrategy() throws Exception {


        xml = "<transport>\n" +
                "<useFtp>1</useFtp>\n" +
                "<transportStrategy>topspeeds</transportStrategy>\n"+
                "<speedLimit>10</speedLimit>\n" +
                "<concurrentLimit>30</concurrentLimit>"+
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportConfigurationSteps.checkErrorForInvalidTransportStrategy(ipportId, xml);
    }
}
