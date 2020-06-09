package com.arvid.okesclient.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Slf4j
@PropertySource("classpath:application.properties")
public class OkEsClientConfiguration {
    public OkEsClientConfiguration(){
        log.info("OkEsClientConfiguration loaded...");
    }
}
