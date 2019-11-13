package com.sambatech.challenge.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sambatech.challenge.dto.DTOVideo;
import com.sambatech.challenge.service.IVideoService;
import com.sambatech.challenge.service.exception.ExpiredTimestampException;
import com.sambatech.challenge.service.exception.FutureTimestampException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/")
public class VideoResource {

	@Autowired
	@Qualifier("videoService")
	private IVideoService videoService;

	@ApiOperation(value = "Create a new Video resource")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Resource created"),
			@ApiResponse(code = 204, message = "Old resource") })
	@PostMapping(value = "videos", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody DTOVideo dto) throws ExpiredTimestampException, FutureTimestampException {
		videoService.add(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
