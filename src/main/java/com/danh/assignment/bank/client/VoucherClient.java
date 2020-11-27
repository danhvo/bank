package com.danh.assignment.bank.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danh.assignment.bank.configuration.ClientConfiguration;
import com.danh.assignment.bank.dto.ResponseDTO;
import com.danh.assignment.bank.dto.VoucherDTO;

@FeignClient(value = "voucher-client", configuration = ClientConfiguration.class)
public interface VoucherClient {
	@GetMapping(produces = { "application/json" }, path = "code")
	public ResponseDTO<VoucherDTO> getVoucherCode(@RequestParam(value = "slow", required = true) boolean slow,
			@RequestParam(value = "error", required = true) boolean error);
}
