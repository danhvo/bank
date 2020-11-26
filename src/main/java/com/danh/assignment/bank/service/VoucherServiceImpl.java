package com.danh.assignment.bank.service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danh.assignment.bank.client.VoucherClient;
import com.danh.assignment.bank.dto.ResponseDTO;
import com.danh.assignment.bank.entity.Voucher;
import com.danh.assignment.bank.repository.SimRepository;

@Service
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private SimRepository simRepository;
	
	@Autowired
	private VoucherClient voucherClient;
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	private Random random = new Random();
	
	/*@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseDTO<Object> getVoucherCode() {
		boolean slow = random.nextBoolean();
		String fooResourceUrl = "http://localhost:8081/third-party/api/v1/code?slow=";
		ResponseEntity<ResponseDTO> response = restTemplate.getForEntity(fooResourceUrl + slow, ResponseDTO.class);
		return response.getBody();
	}*/
	
	@Override
	public ResponseDTO<Object> getVoucherCode() {
		boolean slow = random.nextBoolean();
		boolean error = random.nextBoolean();
		return voucherClient.getVoucherCode(slow, error);
	}

	@Override
	public List<String> getVouchersByPhoneNumber(String phoneNumber) {
		List<Voucher> vouchers = simRepository.findByNumber(phoneNumber).map(sim -> sim.getVouchers()).orElse(Collections.emptyList());
		return vouchers.stream().map(voucher -> voucher.getCode()).collect(Collectors.toList());
	}

}
