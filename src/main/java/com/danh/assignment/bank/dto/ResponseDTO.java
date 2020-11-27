package com.danh.assignment.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
	@JsonProperty("status")
	private String status;

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("host")
	private String host;

	@JsonProperty("data")
	private T data;

	@JsonProperty("message")
	private String message;
}
