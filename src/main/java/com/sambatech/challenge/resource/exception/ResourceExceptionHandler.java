package com.sambatech.challenge.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sambatech.challenge.service.exception.ExpiredTimestampException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ExpiredTimestampException.class)
	public ResponseEntity<StandardError> storeVideo(ExpiredTimestampException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NO_CONTENT.value(), e.getMessage(), System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(err);
	}

}
