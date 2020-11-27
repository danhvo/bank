package com.danh.assignment.bank.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.danh.assignment.bank.entity.Sim;
import com.danh.assignment.bank.entity.Voucher;
import com.danh.assignment.bank.repository.SimRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
	@Autowired
	private SimRepository simRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("Start loading data...");
		Sim viettel = Sim.builder().number("0389555555").build();
		viettel.addVoucher(Voucher.builder().code("1234").sim(viettel).build());
		simRepository.save(viettel);
		Sim mobifone = Sim.builder().number("0935717171").build();
		mobifone.addVoucher(Voucher.builder().code("2345").sim(mobifone).build());
		simRepository.save(mobifone);
		Sim vinaphone = Sim.builder().number("0886008346").build();
		vinaphone.addVoucher(Voucher.builder().code("6789").sim(vinaphone).build());
		simRepository.save(vinaphone);

		System.out.println("\nfindAll()");
		simRepository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1L)");
		simRepository.findById(1l).ifPresent(x -> System.out.println(x));
		log.info("End loading data...");
	}

}
