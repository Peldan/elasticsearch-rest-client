package com.arvid.okesclient.client;

public interface ClientWrapper {
    String create(String indexName);
    String delete(String indexName);
    String get(String indexName);
    String getMapping(String indexName);
    boolean exists(String indexName);
}
