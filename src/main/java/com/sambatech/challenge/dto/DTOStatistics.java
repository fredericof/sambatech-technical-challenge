package com.sambatech.challenge.dto;

import io.swagger.annotations.ApiModelProperty;

public class DTOStatistics {

	@ApiModelProperty(value = "Sum of all videos duration added in the last 60 seconds")
	private double sum;

	@ApiModelProperty(value = "Mean of all videos duration added in the last 60 seconds")
	private double avg;

	@ApiModelProperty(value = "Longest of a video duration added in the last 60 seconds")
	private double max;

	@ApiModelProperty(value = "Shorter of a video duration added in the last 60 seconds")
	private double min;

	@ApiModelProperty(value = "Number of videos added in the last 60 seconds")
	private long count;

	public DTOStatistics() {
		super();
	}

	public DTOStatistics(double sum, double avg, double max, double min, long count) {
		super();
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
