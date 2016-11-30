package com.quantil.stepLibrary.domains;

import com.mileweb.sdk.cloudcdn.model.*;
import com.quantil.client.sdk.SDKDomainClient;
import com.quantil.entities.response.domain.DomainResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.Helper;
import com.quantil.global.TestData;
import com.quantil.global.TestDataKey;
import com.quantil.service.ProjectData;
import com.quantil.validation.ResponseValidator;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;

/**
 * Created by saddius on 9/25/2016.
 */
public class CreateDomainSteps {
    static SDKDomainClient client;
    public static Domain domain, streamDom, downloadDom;

    static {
        client = SDKDomainClient.getClient(ProjectData.selectedAPIEndpoint);
    }

    @Step
    public void beforeStep() throws TestInitializationException, ValidationException, InterruptedException {
//        try {
        domain = Helper.createDomain(ServiceType.WEB, "euna");
//            streamDom = Helper.createDomain(ServiceType.STREAM, "cn");
        downloadDom = Helper.createDomain(ServiceType.DOWNLOAD, "apac");

        DomainResponse resultDomain = client.createDomain(domain);
//            DomainResponse resultStream = client.createDomain(streamDom);
        DomainResponse resultDown = client.createDomain(downloadDom);
//            String domainId = resultDomain.getLocation().replace("https://api.quantil.com/api/domain/","");
        String domainId = resultDomain.getLocation().substring(resultDomain.getLocation().lastIndexOf("/") + 1);
        domain.setDomainId(domainId);
        domainId = resultDown.getLocation().substring(resultDomain.getLocation().lastIndexOf("/") + 1);
        downloadDom.setDomainId(domainId);
//
//            HashMap<String, String> dbDom = mySqlConnector.getDBData(String.format("select domain_id from domains where cname = '%s'",
//                    resultDomain.getCname())).get(0);
//            domain.setDomainId(dbDom.get("domain_id"));
//
//            HashMap<String, String> dbDomStream = mySqlConnector.getDBData(String.format("select domain_id from domains where cname = '%s'",
//                    resultStream.getCname())).get(0);
//            streamDom.setDomainId(dbDomStream.get("domain_id"));
//
//            HashMap<String, String> dbDomDown = mySqlConnector.getDBData(String.format("select domain_id from domains where cname = '%s'",
//                    resultDown.getCname())).get(0);
//            downloadDom.setDomainId(dbDomDown.get("domain_id"));
//
//            QueryDomainResult qResDomain, qResStream, qResDown;
     /*   DomainResponse qResDomain;

            do {
                Thread.sleep(30 * 1000);
                qResDomain = client.getDomain(domain.getDomainId());
//                qResStream = cloudCDNClient.queryDomain(streamDom.getDomainId());
//                qResDown = cloudCDNClient.queryDomain(downloadDom.getDomainId());
            } while (qResDomain.getDomain().getStatus() == DeployedStatus.InProgress);*/
//                    || qResStream.getDomain().getStatus() == DeployedStatus.InProgress
//                    || qResDown.getDomain().getStatus() == DeployedStatus.InProgress);
//        } catch (Throwable e) {
//            e.printStackTrace();
//            Assume.assumeNoException(e);
//        }
//
//        try {
//            // Retrieving cnc_certificate_id for creating domain with Ssl
//            List<HashMap<String, String>> sslDb = mySqlConnector.getDBData(ProjectConstants.sqlRandomSsl);
//            String sslIdFromDB = sslDb.get(0).get("cnc_certificate_id");
//            // Creating domain with attached ssl certificate
//            UseSsL ssl = new UseSsL();
//            ssl.setUseSsl(true);
//            ssl.setSslId(sslIdFromDB);
//
//            sslDomain = Helper.createDomain(ServiceType.WSA, "euna");
//            sslDomain.setUseSsl(ssl);
//            sslDomain.setForcecert(true);
//
//            CreateDomainResult sslResult = cloudCDNClient.createDomain(sslDomain);
//
//            HashMap<String, String> dbSslDom = mySqlConnector.getDBData(String.format(
//                    "select domain_id from domains where cname = '%s'",
//                    sslResult.getCname())).get(0);
//            sslDomain.setDomainId(dbSslDom.get("domain_id"));
//
//            QueryDomainResult qSslRes;
//
//            do {
//                Thread.sleep(30 * 1000);
//                qSslRes = cloudCDNClient.queryDomain(sslDomain.getDomainId());
//            } while (qSslRes.getDomain().getStatus() == DeployedStatus.InProgress);
//        } catch (Throwable e) {
//            e.printStackTrace();
//            Assume.assumeNoException(e);
//        }
    }

    @Step
    public void createDomainMandatoryFields() throws TestInitializationException, ValidationException {

        Domain simpleDomain = Helper.createSimpleDomain(ServiceType.WSA, "euna");
        DomainResponse res = client.createDomain(simpleDomain);

        ResponseValidator.validateResponse(res);

        Assert.assertTrue("Domain is not successfully created", res.getXmlResult().contains("success"));

    }

    @Step
    public void checkDomain() throws TestInitializationException, ValidationException {

        DomainResponse res = client.getDomain(domain.getDomainId());

        ResponseValidator.validateResponse(res);

//        if (res != null) {
        Assert.assertEquals("Domain name is not equal", res.getDomain().getDomainName(), domain.getDomainName());
        Assert.assertEquals("Comments field is not equal", res.getDomain().getComment(), domain.getComment());
        Assert.assertEquals("Service type is not equal", res.getDomain().getServiceType().toString(), domain.getServiceType().toString());
//        } else Assert.fail("DB returns no data.");

    }

    @Step
    public void checkLogOption() throws TestInitializationException, ValidationException {
        DomainResponse res = client.getDomainHistoryRecord(domain.getDomainId(), "1");

        ResponseValidator.validateResponse(res);

//        if (res != null) {
        Assert.assertEquals("Log storage days are not equal", res.getDomain().getLogOption().getLogStorageDay(), domain.getLogOption().getLogStorageDay());
        Assert.assertEquals("Log storage days are not equal", res.getDomain().getLogOption().getTimeZone(), domain.getLogOption().getTimeZone());

//        } else Assert.fail("DB returns no data.");
    }

    @Step
    public void checkOriginConfig() throws TestInitializationException, ValidationException {
        DomainResponse res = client.getDomainHistoryRecord(domain.getDomainId(), "1");

        ResponseValidator.validateResponse(res);

        OriginConfig oc = domain.getOriginConfig();

//        if (res != null) {
        if (oc.getOriginDomainName() != null) {
            Assert.assertEquals("Origin config is not equal", res.getDomain().getOriginConfig().getOriginDomainName(), oc.getOriginDomainName());
        }

        if (oc.getOriginIps() != null) {
            Assert.assertTrue("Origin ips are not equal", oc.getOriginIps().containsAll(res.getDomain().getOriginConfig().getOriginIps()) &&
                    res.getDomain().getOriginConfig().getOriginIps().containsAll(oc.getOriginIps()));
        }

            /*for (OriginPolicyConfig opc : oc.getOriginPolicyConfigList()) {
                // TODO: possible issue with encoding
//            System.out.println("ISP: " + opc.getIsp());
//            Assert.assertTrue("Origin policy config does not contain ISP",
//                    confXml.contains(opc.getIsp().toString().toLowerCase()));

                for (String masterIp : opc.getMasterIpSet()) {
                    Assert.assertTrue(String.format("Origin policy config does not contain master ip (%s)", masterIp),
                            confXml.contains(masterIp));
                }
                for (String backIp : opc.getBackupIpSet()) {
                    Assert.assertTrue(String.format("Origin policy config does not contain backup ip (%s)", backIp),
                            confXml.contains(backIp));
                }
            }*/
//        } else Assert.fail("DB returns no data.");
    }

    @Step
    public void checkCacheBehavior() throws TestInitializationException, ValidationException {

        DomainResponse res = client.getDomainHistoryRecord(domain.getDomainId(), "1");
        ResponseValidator.validateResponse(res);


//        if (res != null) {
        for (int i = 0; i < domain.getCacheBehaviors().size(); i++) {
            Assert.assertEquals("Path pattern doesn't match.", domain.getCacheBehaviors().get(i).getPathPattern(), res.getDomain().getCacheBehaviors().get(i).getPathPattern());
            Assert.assertEquals("Cache time doesn't match.", domain.getCacheBehaviors().get(i).getCacheTtl(), res.getDomain().getCacheBehaviors().get(i).getCacheTtl());
            Assert.assertEquals("Ignore origin's No-Cache directive (IONCD) parameter doesn't match.", domain.getCacheBehaviors().get(i).isIgnoreCacheControl(),
                    res.getDomain().getCacheBehaviors().get(i).isIgnoreCacheControl());
            Assert.assertEquals("Ignore origin's cache time (IOCT) parameter doesn't match.", domain.getCacheBehaviors().get(i).isHonorExpires(),
                    res.getDomain().getCacheBehaviors().get(i).isHonorExpires());
        }
//        } else Assert.fail("DB returns no data.");
    }

//    @Step
//    public void createDomainServiceTypeNotSubscribed() throws Exception {
//
//        CloudCDNClient client = ClientInitializer.initCDNClient(ProjectConstants.strUserEmptyServiceList, ProjectConstants.strApiKeyUserEmptyServiceList);
//        try {
//            client.createDomain(domain);
//            cloudCDNClient = initCDNClient();
//        } catch (ServiceException ex) {
//            cloudCDNClient = initCDNClient();
//            Assert.assertTrue(String.format("Wrong error: %s instead of UnPurchasedServiceTypes", ex.getErrorCode()),
//                    ex.getErrorCode().equals("UnPurchasedServiceTypes"));
//            return;
//        }
//        Assert.fail("Error was not received\r\nPossible cause: 4118");
//
//    }

    @Step
    public void checkVisitControlRules() throws TestInitializationException, ValidationException {

        DomainResponse res = client.getDomainHistoryRecord(domain.getDomainId(), "1");
        ResponseValidator.validateResponse(res);

//        if (res != null) {

        for (int i = 0; i < domain.getVisitControlRules().size(); i++) {
            Assert.assertEquals("Path pattern of Visit Control Rule doesn't match", domain.getVisitControlRules().get(i).getPathPattern(),
                    res.getDomain().getVisitControlRules().get(i).getPathPattern());

            Assert.assertTrue("ForbiddenIps of Visit Control Rule doesn't match", domain.getVisitControlRules().get(i).getForbiddenIps().equals(
                    res.getDomain().getVisitControlRules().get(i).getForbiddenIps()));

            Assert.assertTrue("Valid Referers of Visit Control Rule doesn't match", domain.getVisitControlRules().get(i).getValidReferers().equals(
                    res.getDomain().getVisitControlRules().get(i).getValidReferers()));

            Assert.assertTrue("Invalid Referers of Visit Control Rule doesn't match", domain.getVisitControlRules().get(i).getInvalidReferers().equals(
                    res.getDomain().getVisitControlRules().get(i).getInvalidReferers()));

            Assert.assertEquals("allowNullReferers of Visit Control Rule doesn't match", domain.getVisitControlRules().get(i).getAllowNullReferer(),
                    res.getDomain().getVisitControlRules().get(i).getAllowNullReferer());
        }
//        } else Assert.fail("DB returns no data.");
    }

    @Step
    public void createExistingDomain() throws TestInitializationException, ValidationException {

        Domain simpleDomain = Helper.createSimpleDomain(ServiceType.WSA, "euna");
        simpleDomain.setDomainName(TestData.get(TestDataKey.DOMAIN_NAME.getValue(), String.class));
        DomainResponse res = client.createDomain(simpleDomain);
        Assert.assertTrue("Error wasn't received.", res.getMessage().contains("domain with the same name already exists"));
    }

    @Step
    public void checkServiceAreas() throws TestInitializationException, ValidationException {

        DomainResponse res = client.getDomainHistoryRecord(domain.getDomainId(), "1");
        ResponseValidator.validateResponse(res);

//        if (res != null) {
        Assert.assertTrue(res.getDomain().getServiceArea().contains(domain.getServiceArea()));
//        } else Assert.fail("DB contains no data for requested domain.");
    }

    @Step
    public void checkClientControlRule() throws Exception {

        DomainResponse res = client.getDomainHistoryRecord(downloadDom.getDomainId(), "1");
        ResponseValidator.validateResponse(res);

//        if (res != null) {

        ClientControlRule ccrRes = res.getDomain().getClientControlRule();
        ClientControlRule ccr = downloadDom.getClientControlRule();

        if (ccr != null) {
            if (ccr.getAccessSpeedRules() != null) {
                for (int i = 0; i < ccrRes.getAccessSpeedRules().size() - 1; i++)
                    Assert.assertTrue("Speed - " + String.valueOf(ccr.getAccessSpeedRules().get(i).getSpeed()),
                            ccrRes.getAccessSpeedRules().contains(ccr.getAccessSpeedRules().get(i).getSpeed()));
//                Assert.assertTrue("Pattern - " + asr.getPathPattern(), res.getDomain().getClientControlRule().contains(asr.getPathPattern()));
            }
        }
    }
//        } else Assert.fail("DB contains no data for requested domain.");
}

