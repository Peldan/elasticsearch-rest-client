package com.arvid.okesclient.client;

public interface ClientWrapper {
    String create(EsRequest request);
    String delete(EsRequest request);
    String get(EsRequest request);
    String getMapping(EsRequest request);
    boolean exists(EsRequest request);
}
