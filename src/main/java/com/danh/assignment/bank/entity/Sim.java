package com.danh.assignment.bank.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
@Builder
public class Sim extends BaseEntity{
	
	@Column(unique = true)
	private String number;
	
	@OneToMany(mappedBy = "sim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
	@ToString.Exclude
	private List<Voucher> vouchers;
	
	public void addVoucher(Voucher voucher) {
		if (this.vouchers == null) {
			this.vouchers = new ArrayList<>();
		}
		this.vouchers.add(voucher);
	}
}
