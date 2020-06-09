package com.arvid.okesclient.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientWrapperTest {

    OkEsClient okEsClient = new OkEsClient();
    ClientWrapper clientWrapper = new ClientWrapperImpl(okEsClient, "http://localhost:9200/");

    @Test
    public void createAndExistsTest() {
        String index = "test";
        String createResponse = clientWrapper.create(index);
        assertNotNull(createResponse);
        assertTrue(clientWrapper.exists(index));
        String deleteResponse = clientWrapper.delete(index);
        assertNotNull(deleteResponse);
        assertFalse(clientWrapper.exists(index));
    }

}
