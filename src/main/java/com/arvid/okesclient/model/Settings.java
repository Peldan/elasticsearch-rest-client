package com.arvid.okesclient.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Collections.unmodifiableMap;

class Settings implements Serializable {
    private static final long serialVersionUID = -5883398641435912139L;
    private final Map<String, String> parameters;

    private Settings(){
        this.parameters = new HashMap<>(25);
    }

    static Settings createSettings() {
        return new Settings();
    }

    protected void put(String key, String value){
        Objects.requireNonNull(key, "key cannot be null");
        if(parameters.containsKey(key)){
            throw new IllegalArgumentException("'" + key + "' has already been set. " + key + ":" + parameters.get(value));
        }
        parameters.put(key, value);
    }

    protected Map<String, String> getParameters(){
        return unmodifiableMap(parameters);
    }

}
