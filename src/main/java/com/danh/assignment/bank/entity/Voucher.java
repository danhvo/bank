package com.danh.assignment.bank.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
@Builder
public class Voucher extends BaseEntity{
    private String code;
    
    @ManyToOne
    @ToString.Exclude
    private Sim sim;
}
