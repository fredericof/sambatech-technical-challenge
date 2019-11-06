package com.sambatech.challenge.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sambatech.challenge.dto.DTOVideoResponse;
import com.sambatech.challenge.service.IVideoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/videos")
public class VideoResource {

	@Autowired
	@Qualifier("videoService")
	private IVideoService videoService;
	
	@ApiOperation(value = "Test Video Resource")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Video Resource its OK!")
		})
	@GetMapping(produces = "application/json")
	public ResponseEntity<DTOVideoResponse> videoTestResource() {
		return ResponseEntity.ok().body(videoService.doWork());
	}
}
