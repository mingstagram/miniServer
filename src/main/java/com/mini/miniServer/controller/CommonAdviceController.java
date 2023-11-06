package com.mini.miniServer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mini.miniServer.dto.DefaultResponse;
import com.mini.miniServer.exception.CommonException;

@ControllerAdvice
public class CommonAdviceController {
	
	@ExceptionHandler(CommonException.class)
	public ResponseEntity<?> commonException(CommonException e) {
		DefaultResponse res = new DefaultResponse(e.getCode(), e.getMsg(), null);
		return ResponseEntity.ok(res);
	}

}
