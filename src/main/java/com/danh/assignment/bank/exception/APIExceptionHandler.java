package com.danh.assignment.bank.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.danh.assignment.bank.dto.ErrorDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Object handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
		log.error(e.getMessage(), e);
		return ErrorDTO.builder().code("3244").message(e.getMessage()).build();
	}

}
