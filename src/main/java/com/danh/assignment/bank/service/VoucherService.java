package com.danh.assignment.bank.service;

import java.util.List;

import com.danh.assignment.bank.dto.ResponseDTO;

public interface VoucherService {
	List<String> getVouchersByPhoneNumber(String phoneNumber);
	ResponseDTO<Object> getVoucherCode();
}
