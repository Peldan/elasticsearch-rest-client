package com.arvid.okesclient.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientWrapperTest {
    @Test
    public void createRequestNoParametersTest() {
        EsRequest request = EsRequest.forIndex("index");
        request.build();
    }

    @Test
    public void createRequestWithParametersTest() {
        EsRequest request = EsRequest.forIndex("index");
        request.putParameter("Content-Type", "application/json");
        request.putParameter("Accept", "application/json");
        request.build();
    }

    @Test
    public void createRequestIndexNullTest() {
        assertThrows(NullPointerException.class,
                () -> EsRequest.forIndex(null));
    }
}
