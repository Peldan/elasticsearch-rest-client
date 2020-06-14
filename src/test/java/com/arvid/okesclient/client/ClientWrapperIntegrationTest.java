package com.arvid.okesclient.client;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ClientWrapperIntegrationTest {

    OkEsClient okEsClient = new OkEsClient();
    ClientWrapper clientWrapper = new ClientWrapperImpl(okEsClient, "http://localhost:9200/");

    @Test
    public void createDeleteTest() {
        String index = "test";
        String createResponse = clientWrapper.create(EsRequest.forIndex(index));
        assertNotNull(createResponse);
        assertTrue(clientWrapper.exists(EsRequest.forIndex(index)));
        String deleteResponse = clientWrapper.delete(EsRequest.forIndex(index));
        assertNotNull(deleteResponse);
        assertFalse(clientWrapper.exists(EsRequest.forIndex(index)));
    }

}
