package com.danh.assignment.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor 
@NoArgsConstructor 
public class ErrorDTO {
	private String code;
	private String message;
}
