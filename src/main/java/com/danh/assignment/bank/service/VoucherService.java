package com.danh.assignment.bank.service;

import java.util.List;

import com.danh.assignment.bank.dto.ResponseDTO;
import com.danh.assignment.bank.dto.VoucherDTO;

public interface VoucherService {
	List<String> getVouchersByPhoneNumber(String phoneNumber);
	ResponseDTO<VoucherDTO> getVoucherCode(String phoneNumber);
}
