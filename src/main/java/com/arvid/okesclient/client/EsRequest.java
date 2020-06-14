package com.arvid.okesclient.client;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import okhttp3.FormBody;
import okhttp3.RequestBody;

import java.io.Serializable;
import java.util.Objects;

@ToString
@EqualsAndHashCode
public class EsRequest implements Serializable {
    private static final long serialVersionUID = 8661721521996623358L;
    private final String indexName;
    private RequestBody requestBody;
    private transient FormBody.Builder formBodyBuilder;

    private EsRequest(String indexName) {
        this.indexName = indexName;
    }

    public static EsRequest forIndex(String indexName) {
        Objects.requireNonNull(indexName);

        return new EsRequest(indexName);
    }

    EsRequest build() {
        if(formBodyBuilder != null){
            this.requestBody = formBodyBuilder.build();
        }
        return this;
    }

    public void putParameter(String key, String value) {
        if (formBodyBuilder == null) {
            formBodyBuilder = new FormBody.Builder();
        }
        formBodyBuilder.add(key, value);
    }

    public String getIndexName() {
        return indexName;
    }


}
