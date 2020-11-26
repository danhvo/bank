package com.danh.assignment.bank.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ClientConfiguration {
	
    @Autowired
    private VoucherClientProperties voucherClientProperties;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder.Default();
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor urlInterceptor() {
    	log.info("voucher-client.url=" + voucherClientProperties.getUrl());
        return template -> template.target(voucherClientProperties.getUrl());
    }
}
