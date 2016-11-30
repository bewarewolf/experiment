package com.quantil.interfaces;

import com.quantil.entities.response.GenericResponse;

/**
 * Created by pchelintsev on 11/16/2016.
 */
public interface IHdt {

    GenericResponse createTransport(String xml);
    GenericResponse deleteTransport(String transportId);
    GenericResponse getTransport(String transportId);
    GenericResponse modifyTransport(String transportId, String xml);
    GenericResponse searchTransportList();
    GenericResponse getTransportHistoryConfiguration(String transportId);
    GenericResponse modifyTransportConfiguration(String transportId,String xml);
    GenericResponse getTransportStrategyList();
    GenericResponse getTransportTypeList();

}
