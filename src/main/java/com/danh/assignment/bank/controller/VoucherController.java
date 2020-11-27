package com.danh.assignment.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danh.assignment.bank.common.StatusConstants;
import com.danh.assignment.bank.dto.ResponseDTO;
import com.danh.assignment.bank.dto.VoucherDTO;
import com.danh.assignment.bank.service.VoucherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/")
@RestController
public class VoucherController {
	@Autowired
	private VoucherService voucherService;

	@GetMapping(produces = { "application/json" }, path = "vouchers/{phoneNumber}/codes")
	public ResponseDTO<Object> getVoucherCodesByPhoneNumber(@PathVariable String phoneNumber) {
		log.info("Start getting Vouchers!");
		Map<String, List<String>> result = new HashMap<>();
		result.put("vouchers", voucherService.getVouchersByPhoneNumber(phoneNumber));
		return ResponseDTO.builder().data(result).code(HttpStatus.OK.value()).status(StatusConstants.STATUS_SUCCESS).build();
	}
	
	@GetMapping(produces = { "application/json" }, path = "vouchers/{phoneNumber}/code")
	public ResponseDTO<VoucherDTO> getVoucherCode(@PathVariable String phoneNumber,  @RequestParam(value = "slow", required = true) boolean slow,
			@RequestParam(value = "error", required = true) boolean error) {
		log.info("Start getting Voucher Codes!");
		return voucherService.getVoucherCode(phoneNumber, slow, error);
	}
}
