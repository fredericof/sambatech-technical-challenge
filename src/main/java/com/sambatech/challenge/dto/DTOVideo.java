package com.sambatech.challenge.dto;

import io.swagger.annotations.ApiModelProperty;

public class DTOVideo {

	@ApiModelProperty(value = "Time duration of video")
	private double duration;

	@ApiModelProperty(value = "Time video was added")
	private long timestamp;

	public DTOVideo() {
		super();
	}

	public DTOVideo(double duration, long timestamp) {
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
