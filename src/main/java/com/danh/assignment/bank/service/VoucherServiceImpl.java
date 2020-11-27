package com.danh.assignment.bank.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danh.assignment.bank.client.VoucherClient;
import com.danh.assignment.bank.dto.ResponseDTO;
import com.danh.assignment.bank.dto.VoucherDTO;
import com.danh.assignment.bank.entity.Sim;
import com.danh.assignment.bank.entity.Voucher;
import com.danh.assignment.bank.repository.SimRepository;

@Service
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private SimRepository simRepository;
	
	@Autowired
	private VoucherClient voucherClient;
	
	@Override
	public ResponseDTO<VoucherDTO> getVoucherCode(String phoneNumber, boolean slow, boolean error) {
		ResponseDTO<VoucherDTO> response = voucherClient.getVoucherCode(slow, false);
		
		VoucherDTO voucher = response.getData();
		if (voucher.getCode() != null) {
			Sim sim = simRepository.findByNumber(phoneNumber).orElse(Sim.builder().number(phoneNumber).build());
			sim.addVoucher(Voucher.builder().code(voucher.getCode()).sim(sim).build());
			simRepository.save(sim);
		}
		return response;
	}

	@Override
	public List<String> getVouchersByPhoneNumber(String phoneNumber) {
		List<Voucher> vouchers = simRepository.findByNumber(phoneNumber).map(sim -> sim.getVouchers()).orElse(Collections.emptyList());
		return vouchers.stream().map(voucher -> voucher.getCode()).collect(Collectors.toList());
	}

}
