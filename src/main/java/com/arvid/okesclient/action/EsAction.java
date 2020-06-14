package com.arvid.okesclient.action;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EsAction {
    CREATE,
    DELETE,
    GET,
    MAPPING("_mapping"),
    EXISTS;

    final String path;

    EsAction(){
        this.path = "";
    }

    public String getPath() {
        return path;
    }
}
