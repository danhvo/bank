package com.danh.assignment.bank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.danh.assignment.bank.entity.Voucher;

public interface VoucherRepository extends CrudRepository<Voucher, Long> {
    List<Voucher> findByCode(String code);
}
