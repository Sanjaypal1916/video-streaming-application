package com.project.videostreamer.service;

import org.springframework.web.multipart.MultipartFile;

import com.project.videostreamer.entities.video;

public interface videoService {

//	save
	video save(video v1, MultipartFile file);
	
//	getById
	video getById(String videoId);
	
//	getByTitle
	video getByTitle(String title);
	
//	getAll
	video getAll();
	
	
}
