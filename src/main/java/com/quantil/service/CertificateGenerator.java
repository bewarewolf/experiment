package com.quantil.service;



import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.cert.X509Certificate;
import java.util.Date;

import com.mileweb.sdk.cloudcdn.model.Ssl;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.Security;

import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.openssl.PEMEncryptor;
import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.openssl.jcajce.JcePEMEncryptorBuilder;

//import org.bouncycastle.util.encoders.Base64;
public class CertificateGenerator {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static Ssl generateSslFromFile() throws Exception {

        Path pathKey = Paths.get("./generated_certificates/priv.pem");
        byte[] dataKey = Files.readAllBytes(pathKey);

        Path pathCert = Paths.get("./generated_certificates/cert.crt");
        byte[] dataCert = Files.readAllBytes(pathCert);

        Ssl ssl = new Ssl();

        ssl.setSslCertificate(dataCert);
        ssl.setSslKey(dataKey);

        return ssl;
    }

    private static String convertCertificateToPEM(X509Certificate signedCertificate) throws IOException {
        StringWriter signedCertificatePEMDataStringWriter = new StringWriter();
        PEMWriter pemWriter = new PEMWriter(signedCertificatePEMDataStringWriter);
        pemWriter.writeObject(signedCertificate);
        pemWriter.close();
        return signedCertificatePEMDataStringWriter.toString();
    }

    private static String convertToPem(Object obj) throws Exception {
        
        StringWriter signedCertificatePEMDataStringWriter = new StringWriter();
        PEMWriter pemWriter = new PEMWriter(signedCertificatePEMDataStringWriter);
        pemWriter.writeObject(obj);
        pemWriter.close();
        return signedCertificatePEMDataStringWriter.toString();
    }
    
    private static String convertKeyToPEM(PrivateKey signedCertificate) throws IOException {
        StringWriter signedCertificatePEMDataStringWriter = new StringWriter();
        PEMWriter pemWriter = new PEMWriter(signedCertificatePEMDataStringWriter);
        pemWriter.writeObject(signedCertificate);
        pemWriter.close();
        return signedCertificatePEMDataStringWriter.toString();
    }

    public static String[] createStringKeyCert(String pass) throws Exception {
        
        String[] out = new String[2];
        
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        X509Certificate chain = generateCertificate(keyPair);

        JcePEMEncryptorBuilder bld = new JcePEMEncryptorBuilder("DES-CBC");        
        bld.setProvider("BC");            
        
        java.security.MessageDigest md = 
            java.security.MessageDigest.getInstance("MD5"); 
        byte[] md5date = md.digest(new Date().toString().getBytes());
        
        PEMEncryptor enc = bld.build(pass.toCharArray());
        
        StringWriter certwr = new StringWriter();
        PEMWriter certWriter = new PEMWriter(certwr);
        certWriter.writeObject(chain, enc);
        certWriter.close();       
                
        out[1] = certwr.toString();
        
        StringWriter keywr = new StringWriter();
        PEMWriter keyWriter = new PEMWriter(keywr);
        keyWriter.writeObject(keyPair.getPrivate(), enc);
        keyWriter.close();
        
        out[0] = keywr.toString();
        
        return out;
    }
    
    public static Ssl anotherCert() throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        Date startDate = new Date(System.currentTimeMillis() - 50000);
        Date endDate = new Date(2030, 1, 1);
        BigInteger serial = BigInteger.valueOf(System.currentTimeMillis());
        //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);

        String cn = "mwtrial.info";
        
        builder.addRDN(BCStyle.OU, "");
        builder.addRDN(BCStyle.O, "CSIRO");
        builder.addRDN(BCStyle.C, "AU");
        builder.addRDN(BCStyle.E, "me");
        builder.addRDN(BCStyle.CN, cn);

        ContentSigner sigGen = new JcaContentSignerBuilder("SHA1WithRSAEncryption")
                .setProvider("BC").build(keyPair.getPrivate());
        X509v3CertificateBuilder certGen = new JcaX509v3CertificateBuilder(builder.build(),
                serial, startDate, endDate, builder.build(), keyPair.getPublic());
        X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC")
                .getCertificate(certGen.build(sigGen));

        String k = convertKeyToPEM(keyPair.getPrivate());
        String c = convertCertificateToPEM(cert);
        
        Ssl ssl = new Ssl();
        ssl.setSslCertificate(c.getBytes("UTF-8"));
        ssl.setSslKey(k.getBytes("UTF-8"));
        ssl.setCommonNames(cn);
        ssl.setIsShared(false);
        ssl.setExpirationDate(endDate);
        
        
        return ssl;
    }

    static X509Certificate generateCertificate(KeyPair keyPair) throws Exception {

        Date startDate = new Date(System.currentTimeMillis() - 50000);
        Date endDate = new Date(2030, 1, 1);
        BigInteger serial = BigInteger.valueOf(System.currentTimeMillis());
        //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);

        builder.addRDN(BCStyle.OU, "");
        builder.addRDN(BCStyle.O, "CSIRO");
        builder.addRDN(BCStyle.C, "AU");
        builder.addRDN(BCStyle.E, "me");
        builder.addRDN(BCStyle.CN, "mwtrial.info");

        ContentSigner sigGen = new JcaContentSignerBuilder("SHA1WithRSAEncryption")
                .setProvider("BC").build(keyPair.getPrivate());
        X509v3CertificateBuilder certGen = new JcaX509v3CertificateBuilder(builder.build(),
                serial, startDate, endDate, builder.build(), keyPair.getPublic());
        X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC")
                .getCertificate(certGen.build(sigGen));

        return cert;
    }
    
}
