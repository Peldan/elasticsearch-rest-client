package com.arvid.okesclient.client;

import com.arvid.okesclient.action.EsAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
    public String create(EsRequest request) {
        Objects.requireNonNull(request, "request cannot be null");
        request = request.build();
        return okEsClient.put(transformPath(request.getIndexName(), CREATE));
    }

    @Override
    public String delete(EsRequest request) {
        Objects.requireNonNull(request, "request cannot be null");
        request = request.build();
        return okEsClient.delete(transformPath(request.getIndexName(), DELETE));
    }

    @Override
    public String get(EsRequest request) {
        Objects.requireNonNull(request, "request cannot be null");
        request = request.build();
        return okEsClient.get(transformPath(request.getIndexName(), GET));
    }

    @Override
    public String getMapping(EsRequest request) {
        Objects.requireNonNull(request, "request cannot be null");
        request = request.build();
        return okEsClient.get(transformPath(request.getIndexName(), MAPPING));
    }

    @Override
    public boolean exists(EsRequest request) {
        Objects.requireNonNull(request, "request cannot be null");
        request = request.build();
        return okEsClient.head(transformPath(request.getIndexName(), EXISTS));
    }

    private String transformPath(String index, EsAction action){
        if(action.getPath().length() > 1){
            return elasticUrl + index + "/" + action.getPath();
        }
        return elasticUrl + index;
    }

}
