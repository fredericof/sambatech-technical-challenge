package com.sambatech.challenge.service.exception;

public class ExpiredTimestampException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExpiredTimestampException(String msg) {
		super(msg);
	}

	public ExpiredTimestampException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
