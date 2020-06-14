package com.arvid.okesclient.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
@Slf4j
class OkEsClient {

    private final OkHttpClient client;

    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    protected OkEsClient(){
        client = new OkHttpClient();
    }

    protected String get(String url){
        Request request = getBuilderForUrl(url)
                .build();
        return getResponseAsString(request);
    }

    protected String delete(String url){
        Request request = getBuilderForUrl(url)
                .delete(null)
                .build();
        return getResponseAsString(request);
    }

    protected String put(String url){
        return put(url, "");
    }

    protected String put(String url, String json) {
        return put(url, json, JSON);
    }

    protected String put(String url, String json, MediaType mediaType) {
        RequestBody body = RequestBody.create(json, mediaType);
        Request request = getBuilderForUrl(url)
                .put(body)
                .build();
        return getResponseAsString(request);
    }

    protected String post(String url, String json){
        return post(url, json, JSON);
    }

    protected String post(String url, String json, MediaType mediaType){
        RequestBody body = RequestBody.create(json, mediaType);
        Request request = getBuilderForUrl(url)
                .post(body)
                .build();
        return getResponseAsString(request);
    }

    protected boolean head(String url){
        Request request = getBuilderForUrl(url)
                .head()
                .build();
        return isSuccessful(request);
    }

    private Request.Builder getBuilderForUrl(String url){
        return new Request.Builder()
                .url(url);
    }

    private boolean isSuccessful(Request request){
        try(Response response = executeRequest(client.newCall(request))){
            return response.isSuccessful();
        } catch (Exception ex){
            log.error("Fel vid exekvering av request {}", request, ex);
            return false;
        }
    }

    private String getResponseAsString(Request request) {
        String toReturn;
        try (Response response = executeRequest(client.newCall(request))){
            toReturn = Objects.requireNonNull(response.body()).string();
        } catch (Exception e){
            toReturn = e.getMessage();
        }
        return toReturn;
    }

    private Response executeRequest(Call call) throws IOException {
        return call.execute();
    }

}
