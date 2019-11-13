package com.sambatech.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sambatech.challenge.dto.DTOVideo;
import com.sambatech.challenge.service.exception.ExpiredTimestampException;
import com.sambatech.challenge.service.exception.FutureTimestampException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VideoServiceTest {

	@Autowired
	private VideoServiceImpl videoService;

	@Test(expected = ExpiredTimestampException.class)
	public void should_throw_expired_timestamp_exception() throws ExpiredTimestampException {

		DTOVideo dto = new DTOVideo(200.3, System.currentTimeMillis() - 61000);
		videoService.add(dto);
	}

	@Test(expected = FutureTimestampException.class)
	public void should_throw_future_timestamp_exception() throws FutureTimestampException {

		DTOVideo dto = new DTOVideo(200.3, System.currentTimeMillis() + 61000);
		videoService.add(dto);
	}

	@Test
	public void should_add_video() throws ExpiredTimestampException, FutureTimestampException {

		DTOVideo dto = new DTOVideo(200.3, System.currentTimeMillis());
		videoService.add(dto);

		assertEquals(dto.getDuration(), (videoService.getVideoWindow().get(dto.getTimestamp())).getDuration());
		assertEquals(dto.getTimestamp(), (videoService.getVideoWindow().get(dto.getTimestamp())).getTimestamp());
	}

}
