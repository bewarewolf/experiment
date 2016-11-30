package com.quantil.global;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.mileweb.sdk.cloudcdn.model.*;
import com.mileweb.sdk.maa.app.model.*;

public class Helper {

    public static String longUserPwd = "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop";
	public static String createDomainName() {
        return String.format("testdomain.%d.mwtrial.info", System.currentTimeMillis());
    }

    public static String createDomainName(ServiceType st) {
        return String.format("testdomain.%s.%d.mwtrial.info", st.toString(), System.currentTimeMillis());
    }

    public static Domain createDomain(ServiceType st, String area) {
        Domain domain = new Domain();


        DomainLogOption dlo = new DomainLogOption();
        dlo.setLogStorageDay(5);
        dlo.setTimeZone(2);
        domain.setLogOption(dlo);

        domain.setServiceType(st);
        domain.setServiceArea(area);

        String domainName = Helper.createDomainName(st);
        domain.setDomainName(domainName);
        domain.setComment("test comment");

        OriginConfig config = new OriginConfig();
        config.addOriginIp(createIp());
        config.addOriginIp(createIp());

        domain.setOriginConfig(config);

        domain.addCacheBehavior(Helper.createCacheBehavior());

        UseSsL use = new UseSsL();
        use.setUseSsl(false);
        domain.setUseSsl(use);

        domain.addVisitControlRule(Helper.createVisitControlRule());

        domain.getOriginConfig().addOriginIp(Helper.createIp());
        domain.getOriginConfig().addOriginIp(Helper.createIp());
        domain.getOriginConfig().addOriginIp(Helper.createIp());

        domain.getOriginConfig().addOriginRule(Helper.createOriginRule());
        domain.getOriginConfig().addOriginRule(Helper.createOriginRule());
        //
        domain.addQueryStringSetting(Helper.createQueryStringSetting());

        domain.setClientControlRule(Helper.createClientControlRule());

        domain.setVideoDragRule(Helper.createVideoDragRule());

        domain.setDownloadNotifyRuleConfig(Helper.createDownloadNotifyRule());

        domain.addAuthorizeRequestToOriginRule(Helper.createAuthorizeRequestToOriginRule());

        HttpHeaderRule hhr = new HttpHeaderRule();
        hhr.setDateUpdate(true);

        HeaderModifyRule hr = new HeaderModifyRule();

        domain.setHttpHeaderRule(hhr);

//        OriginPolicyConfig originPolicy = new OriginPolicyConfig();
//        originPolicy.addBackupIp(createIp());
//        originPolicy.addMasterIp(createIp());
//        originPolicy.setDetectUrl("http://" + createDomainName());
//        originPolicy.setDetectPeriod((long) 300);
//        originPolicy.addIsp(ISP.all);
//        config.addOriginPolicyConfig(originPolicy);
        domain.setOriginConfig(config);
        //domain.setStatus(DeployedStatus.Deployed);

        domain.setForcecert(false);

        return domain;
    }

    public static Domain createDomain(ServiceType st, String area, boolean enabled) {
        Domain dom = createDomain(st, area);
        dom.setEnabled(enabled);

        return dom;
    }
    
    public static Domain createRandomDomain() {
    	
    	Domain dom = createDomain(ServiceType.WEB, "nc");
        
        return dom;
    }

    public static Domain createSimpleDomain(ServiceType st, String area) {
        Domain domain = new Domain();

        DomainLogOption dlo = new DomainLogOption();
        dlo.setLogStorageDay(5);
        dlo.setTimeZone(2);
        domain.setLogOption(dlo);

        domain.setServiceType(st);
        domain.setServiceArea(area);

        String domainName = Helper.createDomainName(st);
        domain.setDomainName(domainName);

        OriginConfig config = new OriginConfig();
        config.addOriginIp(createIp());

        domain.setOriginConfig(config);

        return domain;
    }

    public static String createIp() {
        Random rand = new Random();
        return String.format("%d.%d.%d.%d", rand.nextInt(254) + 1, rand.nextInt(255), rand.nextInt(255), rand.nextInt(254) + 1);
    }



    public static String createAccessPort() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9999));
    }
    
    public static OriginRule createOriginRule() {
        OriginRule or = new OriginRule();
        or.addOriginIp(Helper.createIp());
        or.addOriginIp(Helper.createIp());
        or.setFileExtensions(".cer");
        or.setIgnoreCase(true);
        or.setModifiedOption(2);
        or.setModifiedPath("/img");
        or.setOriginHostHeader("http://" + Helper.createDomainName());
        or.setOriginPort("1010");
        try{
        Thread.sleep(1 * 1000);}
        catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        or.setPath("http://" + Helper.createDomainName() + "/image");

        return or;
    }

    public static CacheBehavior createCacheBehavior() {

        Random r = new Random();

        CacheBehavior cb = new CacheBehavior();
        cb.setIgnoreCacheControl(r.nextBoolean());
        cb.setCacheTtl(String.valueOf(r.nextInt(360)));
        cb.setPathPattern("*.*");
        cb.setHonorExpires(r.nextBoolean());

        return cb;
    }

    public static VisitControlRule createVisitControlRule() {

        VisitControlRule vcr = new VisitControlRule();
        vcr.addForbiddenIp(Helper.createIp());
        vcr.addInvalidReferer(Helper.createDomainName());
        vcr.addInvalidReferer(Helper.createDomainName());
        vcr.addValidReferer(Helper.createDomainName());
        vcr.setAllowNullReferer(true);
        vcr.setPathPattern("/*.txt");

        return vcr;
    }

    public static QueryStringSetting createQueryStringSetting() {

        QueryStringSetting qss = new QueryStringSetting();
        qss.setIgnoreQueryString(true);
        qss.setPathPattern("/*.exe");

        return qss;
    }

    public static ClientControlRule createClientControlRule() {

        ClientControlRule ccr = new ClientControlRule();
        AccessSpeedRule asr = new AccessSpeedRule();
        asr.setPathPattern("/*.avi");
        asr.setSpeed((float) 1024);
        ccr.addAccessSpeedRule(asr);

        return ccr;
    }

    public static VideoDragRule createVideoDragRule() {

        VideoDragRule r = new VideoDragRule();
        r.setDragMode(VideoDragMode.TIME);
        r.setEndFlag("end");
        r.setPathPattern("/*.mpg");
        r.setStartFlag("start");

        return r;
    }

    public static DownloadNotifyRuleConfig createDownloadNotifyRule() {

        DownloadNotifyRule dnr = new DownloadNotifyRule();
        dnr.setExceptPathPattern("/*.exe");
        dnr.setIgnoreCase(Boolean.TRUE);
        dnr.setNotifyHttpMethod("GET");
        dnr.setNotifyParam("#header{Date}&#cookie{somecookie}");
        dnr.setNotifyUrl("http://" + Helper.createDomainName() + "/");
        dnr.setPathPattern("/*.*");

        DownloadNotifyRuleConfig dnrCfg = new DownloadNotifyRuleConfig();
        dnrCfg.addDownloadNotifyRule(dnr);
        dnrCfg.addNonNotifyStatusCode(404);

        return dnrCfg;
    }

    public static String getISODateString(Date date) {

        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatTime = new SimpleDateFormat("HH:mm:ss");

        return formatDate.format(date) + "T" + formatTime.format(date) + "Z";
    }

    public static AppDTO createApplication() {

        String curTime = String.valueOf(System.currentTimeMillis());

        AppDTO app = new AppDTO();
        app.setDescription(String.format("Description of app_%s", curTime));
        app.setName(String.format("App_%s", curTime));
        app.setPackageName(String.format("maa.mileweb.app%s", curTime));
        app.setPlatform("android");
        app.setType(1);
        ArrayList l = new ArrayList();
        l.add("dfp39r09e");
        app.setFingerprint(l);
        //app.setPseudoDomain();
        //app.setPseudoDomainId("123");
        //Date d = new Date();
        //app.setServiceEndDate(getISODateString(d));
        //app.setServiceStartDate(getISODateString(d));
        app.setUserName("mwtest1");
        app.setServerType(1);
        //app.setId((long)123);

        return app;
    }

    public static DeviceDTO createDevice() {

        DeviceDTO dev = new DeviceDTO();

        long time = System.currentTimeMillis();

        dev.setId(time);
        dev.setName("Device_" + String.valueOf(time));
        dev.setSerial(String.valueOf(time));

        return dev;
    }

    public static DomainDTO createDomainDTO() {

        DomainDTO dom = new DomainDTO();

        long time = System.currentTimeMillis();

        dom.setId(time);
        dom.setUrl(createDomainName());

        return dom;
    }

    public static AuthorizeRequestToOriginRule createAuthorizeRequestToOriginRule() {

        AuthorizeRequestToOriginRule req = new AuthorizeRequestToOriginRule();
        req.setCaseInsensitive(Boolean.TRUE);

        Random r = new Random();
        req.setPathPattern(String.valueOf(r.nextInt(255)) + ".*");

        return req;
    }

    public static CsrContent createCsr() {

        CsrContent csr = new CsrContent();
        csr.setCity("Kharkov");
        csr.setComment("coment");
        csr.setCompany("Nix");
        csr.setDepartment("QA");
        csr.setCountry("UA");
        csr.setEmail("a@b.c");
        csr.setState("Kh");
        csr.setName("csr_" + System.currentTimeMillis());

        return csr;
    }
}
