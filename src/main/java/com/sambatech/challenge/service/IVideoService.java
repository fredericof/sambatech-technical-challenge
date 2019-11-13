package com.sambatech.challenge.service;

import com.sambatech.challenge.dto.DTOVideo;
import com.sambatech.challenge.service.exception.ExpiredTimestampException;
import com.sambatech.challenge.service.exception.FutureTimestampException;

public interface IVideoService {

	void add(DTOVideo dto) throws ExpiredTimestampException, FutureTimestampException;

}
