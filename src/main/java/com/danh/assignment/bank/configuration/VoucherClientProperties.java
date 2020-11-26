package com.danh.assignment.bank.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@RefreshScope
@Configuration
@ConfigurationProperties("voucher-client")
@Getter
@Setter
public class VoucherClientProperties {
	private String url;
}
