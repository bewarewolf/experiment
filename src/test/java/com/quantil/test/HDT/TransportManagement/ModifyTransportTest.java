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
import com.quantil.stepLibrary.transport.ModifyTransportSteps;
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yecht.Data;

/**
 * Created by pchelintsev on 11/17/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.TransportManagement.ModifyTransportTests.class)
public class ModifyTransportTest {

    public static String ipportId;
    public static String vpnId;
    public static String socks5Id;
    public static String xml="";
    public static String xmlParameter="";
    public static String tag="";
    @Steps
    GenericSteps genericSteps;

    @Steps
    ModifyTransportSteps modifyTransportSteps;

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
    public void checkAccessPort() throws Exception {

        tag = "accessPort";
        xmlParameter = "<accessPort>"+Helper.createAccessPort()+"</accessPort>";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkUseUdp() throws Exception {

        tag = "useUdp";
        xmlParameter = "<useUdp>1</useUdp>";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkIpWhiteList() throws Exception {

        tag = "ipWhiteList";
        xmlParameter = "<ipWhiteList>1.2.3.5</ipWhiteList>";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkStatus() throws Exception {

        tag = "status";
        xmlParameter = "<status>disabled</status>";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkComments() throws Exception {

        xmlParameter = "<comments>comment</comments>";
        tag = "comments";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(ipportId, xmlParameter, xml, tag );
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportName() throws Exception {

        xmlParameter = "<transportName>"+Helper.createDomainName()+"</transportName>";
        tag = "transportName";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(vpnId, xmlParameter, xml, tag );
    }



    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkUseFtp() throws Exception {

        xmlParameter = "<useFtp>1</useFtp>";
        tag = "useFtp";
        xml = "<transport>\n" +
                "<useFtp>1</useFtp>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(ipportId, xmlParameter, xml, tag );
    }


    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkUserPwd() throws Exception {

        xmlParameter = "<userPwd>123456</userPwd>";
        tag = "userPwd";
        xml = "<transport>\n" +
               xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameter(vpnId, xmlParameter, xml, tag );
    }





    //Negatives
@Test
@Title("Check that transport checkIpWhiteList can be updated type ipport")
@Priority(value = TestPriority.P1)
@Environment(value = EnvironmentType.HDT)
public void checkCname() throws Exception {

    tag = "cName";
    xmlParameter = "<cName>123.info.qtlcnametest.com</cName>";
    xml = "<transport>\n" +
            xmlParameter + "\n" +
            "</transport>";

    genericSteps.about("Check that transport Xml can be retrieved with type ipport",
            "Input data: to be filled");

    modifyTransportSteps.checkParameterIsNotChanged(ipportId, xmlParameter, xml, tag);
}



    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportType() throws Exception {

        tag = "transportType";
            xmlParameter = "<transportType>vpn</transportType>";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameterIsNotChanged(ipportId, xmlParameter, xml, tag);
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTargetDomain() throws Exception {

        xmlParameter = "<targetDomain>"+Helper.createDomainName()+"</targetDomain>";
        tag = "targetDomain";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameterIsNotChanged(ipportId, xmlParameter, xml, tag );
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTargetPort() throws Exception {

        xmlParameter = "<targetPort>"+Helper.createAccessPort()+"</targetPort>";
        tag = "targetPort";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameterIsNotChanged(ipportId, xmlParameter, xml, tag );
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkUserAccount() throws Exception {

        xmlParameter = "<userAccount>"+Helper.createDomainName()+"</userAccount>";
        tag = "userAccount";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameterIsNotChanged(vpnId, xmlParameter, xml, tag );
    }

    @Test
    @Title("Check that transport checkIpWhiteList can be updated type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportId() throws Exception {

        xmlParameter = "<transportId>1234</transportId>";
        tag = "transportId";
        xml = "<transport>\n" +
                xmlParameter + "\n" +
                "</transport>";

        genericSteps.about("Check that transport Xml can be retrieved with type ipport",
                "Input data: to be filled");

        modifyTransportSteps.checkParameterIsNotChanged(ipportId, xmlParameter, xml, tag );
    }

}
