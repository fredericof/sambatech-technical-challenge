package com.sambatech.challenge.service.exception;

public class FutureTimestampException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FutureTimestampException(String msg) {
		super(msg);
	}

	public FutureTimestampException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
