package com.sambatech.challenge.service;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sambatech.challenge.dto.DTOVideo;
import com.sambatech.challenge.service.exception.ExpiredTimestampException;
import com.sambatech.challenge.service.exception.FutureTimestampException;

@Service
@Qualifier("videoService")
public class VideoServiceImpl implements IVideoService {

	private static final int WINDOW_TIME = 60000;

	private Map<Long, DTOVideo> videoWindow;

	private Queue<Long> controlOfTimestamps;

	private ReentrantLock lock = new ReentrantLock();

	public VideoServiceImpl() {
		this.videoWindow = new ConcurrentHashMap<Long, DTOVideo>();
		this.controlOfTimestamps = new PriorityBlockingQueue<Long>();
	}

	@Scheduled(fixedDelayString = "1000")
	private void removeOlderVideos() {

		Long currentTimestamp = System.currentTimeMillis();

		if (this.videoWindow.isEmpty() || this.controlOfTimestamps.peek() + WINDOW_TIME >= currentTimestamp)
			return;

		lock.lock();
		try {
			while (!this.videoWindow.isEmpty() && this.controlOfTimestamps.peek() + WINDOW_TIME < currentTimestamp) {
				Long key = this.controlOfTimestamps.poll();
				this.videoWindow.remove(key);
			}
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void add(DTOVideo dto) throws ExpiredTimestampException, FutureTimestampException {
		Long currentTimestamp = System.currentTimeMillis();
		if (validateTimestamp(dto.getTimestamp(), currentTimestamp)) {
			lock.lock();
			try {
				this.videoWindow.put(currentTimestamp, dto);
				this.controlOfTimestamps.add(currentTimestamp);
			} finally {
				lock.unlock();
			}
		}
	}

	private boolean validateTimestamp(Long videoTimestamp, Long currentTimeStamp) throws ExpiredTimestampException {
		if (videoTimestamp + WINDOW_TIME < currentTimeStamp)
			throw new ExpiredTimestampException("Expired video timestamp");
		if (currentTimeStamp + WINDOW_TIME < videoTimestamp)
			throw new FutureTimestampException("Future video timestamp");
		return true;
	}

	public Map<Long, DTOVideo> getVideoWindow() {
		return videoWindow;
	}

}
