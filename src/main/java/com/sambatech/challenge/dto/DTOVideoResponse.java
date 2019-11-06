package com.sambatech.challenge.dto;

public class DTOVideoResponse {

	private double duration;

	private long timestamp;

	public DTOVideoResponse(double duration, long timestamp) {
		super();
		this.duration = duration;
		this.timestamp = timestamp;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
