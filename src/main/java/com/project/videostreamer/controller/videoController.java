package com.project.videostreamer.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.videostreamer.entities.video;
import com.project.videostreamer.payload.CustomMessage;
import com.project.videostreamer.service.videoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/videos")
public class videoController {

	@Autowired
	private videoService videoservice;
	
	public videoController(videoService videoservice) {
		super();
		this.videoservice = videoservice;
	}
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestParam("file")MultipartFile file, @RequestParam("title") String title, @RequestParam("description") String description){
		
		video v1 = new video();
		v1.setTitle(title);
		v1.setDescription(description);
		v1.setVideoId(UUID.randomUUID().toString());
		
		video saved = videoservice.save(v1 , file);
		
		if(saved!=null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(v1);
		}else {
			return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(CustomMessage.builder()
					.message("video not uploaded")
					.success(false)
					.build()
					);
		}
		
	}
	

}
