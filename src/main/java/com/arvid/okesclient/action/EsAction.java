package com.arvid.okesclient.action;

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

    EsAction(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
