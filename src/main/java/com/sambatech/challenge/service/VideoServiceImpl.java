package com.sambatech.challenge.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sambatech.challenge.dto.DTOVideoResponse;

@Service
@Qualifier("videoService")
public class VideoServiceImpl implements IVideoService {

	@Override
	public DTOVideoResponse doWork() {
		return new DTOVideoResponse(200.3, 1478192204000L);
	}

}
