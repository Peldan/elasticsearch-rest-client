package com.arvid.okesclient.client;

import com.arvid.okesclient.action.EsAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.arvid.okesclient.action.EsAction.*;

@Component
public class ClientWrapperImpl implements ClientWrapper {

    private final OkEsClient okEsClient;
    private final String elasticUrl;

    @Autowired
    public ClientWrapperImpl(OkEsClient okEsClient,
                             @Value("${elastic.url") String elasticUrl) {
        this.okEsClient = okEsClient;
        this.elasticUrl = elasticUrl;
    }

    @Override
    public String create(String indexName) {
        return okEsClient.put(transformPath(indexName, CREATE));
    }

    @Override
    public String delete(String indexName) {
        return okEsClient.delete(transformPath(indexName, DELETE));
    }

    @Override
    public String get(String indexName) {
        return okEsClient.get(transformPath(indexName, GET));
    }

    @Override
    public String getMapping(String indexName) {
        return okEsClient.get(transformPath(indexName, MAPPING));
    }

    @Override
    public boolean exists(String indexName) {
        return okEsClient.head(transformPath(indexName, EXISTS));
    }

    private String transformPath(String index, EsAction action){
        if(action.getPath().length() > 1){
            return elasticUrl + index + "/" + action.getPath();
        }
        return elasticUrl + index;
    }

}
