package com.sambatech.challenge.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sambatech.challenge.dto.DTOVideoResponse;
import com.sambatech.challenge.service.IVideoService;

@RestController
@RequestMapping(value = "/videos")
public class VideoResource {

	@Autowired
	@Qualifier("videoService")
	private IVideoService videoService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<DTOVideoResponse> videoTestResource() {
		return ResponseEntity.ok().body(videoService.doWork());
	}
}
