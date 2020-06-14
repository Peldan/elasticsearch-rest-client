package com.arvid.okesclient.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@ToString
@EqualsAndHashCode
public class EsRequest implements Serializable {
    private static final long serialVersionUID = 8661721521996623358L;
    private final String indexName;
    private final Settings settings;

    private EsRequest(String indexName) {
        this.indexName = indexName;
        this.settings = Settings.createSettings();
    }

    public static EsRequest forIndex(String indexName) {
        Objects.requireNonNull(indexName, "indexName cannot be null");
        return new EsRequest(indexName);
    }

    public void putParameter(String key, String value) {
        settings.put(key, value);
    }

    public Map<String, String> getParameters() {
        return settings.getParameters();
    }


}
