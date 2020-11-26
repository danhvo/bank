package com.danh.assignment.bank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.danh.assignment.bank.entity.Sim;

public interface SimRepository extends CrudRepository<Sim, Long> {
	Optional<Sim> findByNumber(String number);
}
