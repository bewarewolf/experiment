package com.quantil.client.http;

import com.quantil.auth.APICredentials;
import com.quantil.entities.response.GenericResponse;
import com.quantil.http.HttpProcessor;
import com.quantil.interfaces.IHdt;
import com.quantil.runners.QuantilTestRunner;
import org.apache.logging.log4j.Logger;


/**
 * Created by pchelintsev on 11/16/2016.
 */
public class APIHdtClient implements IHdt {
    static Logger LOG = QuantilTestRunner.LOG;
    HttpProcessor proc;
    private static APIHdtClient exec;
    private static APICredentials current;

    private APIHdtClient(APICredentials cred) throws Exception {


        LOG.info("Initializing API Report client");
        proc = new HttpProcessor(cred.getEndpoint(), cred.getUser(), cred.getKey());
    }

    public static APIHdtClient getClient(APICredentials cred) {

        if (exec == null || current != cred) {

            try {
                exec = new APIHdtClient(cred);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                LOG.error(e);
                throw new RuntimeException(e);
            }
            current = cred;
        }

        return exec;
    }




    @Override
    public GenericResponse createTransport(String xml){
        LOG.info("Executing HDT create transport request");

        String uri = "/hdt/transport";
        return proc.performPost(uri, xml);
    }

    @Override
    public GenericResponse getTransport(String transportId){
        String uri = String.format("/hdt/transport/%s",transportId);
        return proc.performGet(uri);
    }

    @Override
    public GenericResponse getTransportHistoryConfiguration(String transportId){
        String uri = String.format("/hdt/transport/%s/history",transportId);
        return proc.performGet(uri);
    }

    @Override
    public GenericResponse deleteTransport(String transportId){
        LOG.info("Executing HDT delete transport request");

        String uri = String.format("/hdt/transport/%s", transportId);
        return proc.performDelete(uri);
    }

    @Override
    public GenericResponse modifyTransportConfiguration(String transportId, String xml){

        LOG.info("Executing HDT modify transport configuration transport request");

        String uri = String.format("/hdt/private/transport/%s", transportId);
        return proc.performPut(uri,xml);
    }

    @Override
    public GenericResponse modifyTransport(String transportId,String xml){
        LOG.info("Executing HDT modify transport request");

        String uri = String.format("/hdt/transport/%s", transportId);
        return proc.performPut(uri, xml);
    }

    @Override
    public GenericResponse searchTransportList(){
        LOG.info("Executing HDT search transport list request");

        String uri = "/hdt/transport?limit=10000&offset=500";
        return proc.performGet(uri);
    }

    @Override
    public GenericResponse getTransportStrategyList() {
        String uri = "/hdt/transport-strategies";
        return proc.performGet(uri);
    }

    @Override
    public GenericResponse getTransportTypeList() {
        String uri = "/hdt/transport-types";
        return proc.performGet(uri);
    }
}
