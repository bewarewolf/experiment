package com.quantil.test.HDT.TransportManagement;

import com.quantil.annotations.Environment;
import com.quantil.annotations.Priority;
import com.quantil.annotations.Title;
import com.quantil.client.http.APIHdtClient;
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
import com.quantil.thucydides.Features;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by pchelintsev on 11/16/2016.
 */
@RunWith(QuantilTestRunner.class)
@Story(Features.HDT.TransportManagement.CreateTransportTests.class)
public class CreateTransportTest {
    public static String xml;
    public static String transportId;
    @Steps
    GenericSteps genericSteps;

    @Steps
    CreateTransportSteps createTransportSteps;

    @Before
    public void setup() {

        TestData.init();
    }

    @After
    public void deleteTransport(){
        createTransportSteps.deleteTransport(transportId);
    }


    @Test
    @Issue(value = "3207")
    @Title("Check that transport can be created with mandatory fields type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.ANY)
    public void checkTransportCanBeCreatedWithMandatoryFieldsTypeIpport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that transport is created with mandatory fields with type ipport",
                "Input data: to be filled");

        xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";

        transportId =  createTransportSteps.checkTransportIsCreated(xml);
        System.out.println("test test ");

    }

    @Test
    @Title("Check that transport can be created with mandatory fields type vpn")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportCanBeCreatedWithMandatoryFieldsTypeVpn() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that transport is created with mandatory fields with type vpn",
                "Input data: to be filled");

        xml = "<transport>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <useFtp>0</useFtp>\n" +
                "  <userAccount>"+Helper.createDomainName().replace("/","")+"</userAccount>\n" +
                "  <userPwd>1</userPwd>\n" +
                "</transport>";

        transportId =    createTransportSteps.checkTransportIsCreated(xml);
    }

    @Test
    @Title("Check that transport can be created with mandatory fields type socks5")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportCanBeCreatedWithMandatoryFieldsTypeSocks5() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that transport is created with mandatory fields with type socks5",
                "Input data: to be filled");

        xml = "<transport>\n" +
                "  <transportType>socks5</transportType>\n" +
                "  <useFtp>0</useFtp>\n" +
                "  <userAccount>"+Helper.createDomainName().replace("/","")+"</userAccount>\n" +
                "  <userPwd>1</userPwd>\n" +
                "</transport>";

        transportId =    createTransportSteps.checkTransportIsCreated(xml);
    }

    @Test
    @Title("Check that transport can be created with all fields type ipport")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportCanBeCreatedWithAllFieldsTypeIpport() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that transport is created with all fields with type ipport",
                "Input data: to be filled");

        xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <transportName>"+ Helper.createDomainName().replace("/","") +"</transportName>\n" +
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "  <useUdp>0</useUdp>\n" +
                "  <status>enabled</status>\n" +
                "  <accessPort>"+Helper.createAccessPort()+"</accessPort>\n"+
                "  <ipWhiteList>192.168.1.0/26;192.168.10.1-192.168.10.100</ipWhiteList>\n"+
                "  <status>enabled</status>\n"+
                "  <comments>comment</comments>\n"+
                "  <cName>"+ Helper.createDomainName().replace("/","")+".qtlcnametest.com"+"</cName\n>" +
                "</transport>";

        transportId =     createTransportSteps.checkTransportIsCreated(xml);
    }

    @Test
    @Title("Check that transport can be created with all fields type vpn")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportCanBeCreatedWithAllFieldsTypeVpn() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that transport is created with all fields with type vpn",
                "Input data: to be filled");

        xml = "<transport>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <transportName>"+ Helper.createDomainName().replace("/","") +"</transportName>\n" +
                "  <useFtp>0</useFtp>\n" +
                "  <status>enabled</status>\n" +
                "  <userAccount>"+Helper.createDomainName()+"</userAccount>\n" +
                "  <userPwd>1</userPwd>\n" +
                "  <userPwd>1</userPwd>\n"+
                "  <ipWhiteList>192.168.1.0/26;192.168.10.1-192.168.10.100</ipWhiteList>\n"+
                "  <status>enabled</status>\n"+
                "  <comments>comment</comments>\n"+
                "  <cName>"+ Helper.createDomainName().replace("/","")+".qtlcnametest.com"+"</cName\n>" +
                "</transport>";

        transportId =     createTransportSteps.checkTransportIsCreated(xml);
    }


    @Test
    @Title("Check that transport can be created with all fields type socks5")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkTransportCanBeCreatedWithAllFieldsTypeSocks5() throws TestInitializationException, ValidationException {

        genericSteps.about("Check that transport is created with all fields with type socks5",
                "Input data: to be filled");

        xml = "<transport>\n" +
                "  <transportType>socks5</transportType>\n" +
                "  <transportName>"+ Helper.createDomainName().replace("/","") +"</transportName>\n" +
                "  <useFtp>0</useFtp>\n" +
                "  <status>enabled</status>\n" +
                "  <userAccount>"+Helper.createDomainName()+"</userAccount>\n" +
                "  <userPwd>1</userPwd>\n" +
                "  <userPwd>1</userPwd>\n"+
                "  <ipWhiteList>192.168.1.0/26;192.168.10.1-192.168.10.100</ipWhiteList>\n"+
                "  <status>enabled</status>\n"+
                "  <comments>comment</comments>\n"+
                "  <cName>"+ Helper.createDomainName().replace("/","")+".qtlcnametest.com"+"</cName\n>" +
                "</transport>";

        transportId =      createTransportSteps.checkTransportIsCreated(xml);
    }

    //Negatives
    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithoutTransportType() throws Exception {

        xml = "<transport>\n" +
                "<transportType>rrr</transportType>"+
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithoutTransportType(xml);
    }

    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithInvalidTransportType() throws Exception {

        xml = "<transport>\n" +
                "<transportType>rrr</transportType>"+
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithInvalidTransportType(xml);
    }

    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithoutTargetDomainTypeIpport() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithoutTargetDomainTypeIpport(xml);
    }

    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithInvalidTargetDomainTypeIpport() throws Exception {

        xml = "<transport>\n" +

                "  <transportType>ipport</transportType>\n" +
                "  <targetDomain>"+Helper.createAccessPort()+"</targetDomain>\n" +
                "  <targetPort>"+Helper.createAccessPort()+"</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithInvalidTargetDomainTypeIpport(xml);
    }
    ////////////////////
    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithoutTargetPortTypeIpport() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithoutTargetPortTypeIpport(xml);
    }

    @Test
    @Issue("#3580")
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithInvalidTargetPortTypeIpport() throws Exception {

        xml = "<transport>\n" +
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <targetPort>qwe</targetPort>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithInvalidTargetPortTypeIpport(xml);
    }

    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithoutUseFtpTypeIpport() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithoutUseFtpTypeIpport(xml);
    }

    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithInvalidUseFtpTypeIpport() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>ipport</transportType>\n" +
                "  <targetDomain>"+ Helper.createDomainName().replace("/","") +"</targetDomain>\n" +
                "  <targetPort>18888</targetPort>\n" +
                "  <useFtp>invalid</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithInvalidUseFtpTypeIpport(xml);
    }

    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithoutUseFtpTypeVpn() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <userAccount>"+Helper.createDomainName().replace("/","")+"</userAccount>\n" +
                "  <userPwd>1</userPwd>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithoutUseFtpTypeVpn(xml);
    }

    @Test
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithInvalidUseFtpTypeVpn() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <userAccount>"+Helper.createDomainName().replace("/","")+"</userAccount>\n" +
                "  <userPwd>1</userPwd>\n" +
                "  <useFtp>invalid</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithInvalidUseFtpTypeVpn(xml);
    }


    @Test
    @Issue("#3580")
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithoutUserPwdTypeVpn() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <userAccount>"+Helper.createDomainName().replace("/","")+"</userAccount>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithoutUserPwdTypeVpn(xml);
    }

    @Test
    @Issue("#3580")
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithInvalidUserPwdTypeVpn() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <userAccount>"+Helper.createDomainName().replace("/","")+"</userAccount>\n" +
                "  <userPwd>"+Helper.longUserPwd+"</userPwd>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithInvalidUserPwdTypeVpn(xml);
    }

    @Test
    @Issue("#3580")
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithoutUserAccountTypeVpn() throws Exception {

        xml = "<transport>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <userPwd>1</userPwd>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithoutUserAccountTypeVpn(xml);
    }

    @Test
    @Issue("#3580")
    @Title("Check that transport can be created ")
    @Priority(value = TestPriority.P1)
    @Environment(value = EnvironmentType.HDT)
    public void checkErrorForTransportWithInvalidtUserAccountTypeVpn() throws Exception {

        xml = "<transport>\n" +
             //   "  <userAccount>"+Helper.longUserPwd+"</userAccount>\n" +
                "  <userAccount>@@@</userAccount>\n" +
                "  <transportType>vpn</transportType>\n" +
                "  <userPwd>1</userPwd>\n" +
                "  <useFtp>0</useFtp>\n" +
                "</transport>";
        createTransportSteps.checkErrorForTransportWithInvalidUserAccountTypeVpn(xml);
    }





}
