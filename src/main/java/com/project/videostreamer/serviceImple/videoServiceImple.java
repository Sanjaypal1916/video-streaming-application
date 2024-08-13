package com.project.videostreamer.serviceImple;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.project.videostreamer.entities.video;
import com.project.videostreamer.service.videoService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import com.project.videostreamer.repository.repository;

@Service
@RequiredArgsConstructor
public class videoServiceImple implements videoService{
	@Autowired
	private final repository videoRepository;
	
	@Value("${files.video}")
	String dir;
	
	@PostConstruct
	public void init() {
		File file = new File(dir);
		if(!file.exists()) {
			file.mkdir();
			System.out.println("folder created");
		}else {
			System.out.println("folder already created");
		}
	}

	@Override
	public video save(video v1, MultipartFile file) {
		
//		filename 
		try {
			String filename = file.getOriginalFilename();
			String contentType = file.getContentType();
			InputStream inputstream = file.getInputStream();
			
		
		
			
//		filepath
		String cleanFilename = StringUtils.cleanPath(filename);
		
//		folder path : create
		String cleanFolder = StringUtils.cleanPath(dir);
		
//		folder path with filename
		Path path = Paths.get(cleanFolder, cleanFilename);
		
		System.out.println(contentType);
		System.out.println(inputstream);
		System.out.println(path);
		
		
		
//		copy file to the folder
		Files.copy(inputstream, path, StandardCopyOption.REPLACE_EXISTING);
		
		
//		video meta data
		v1.setContentType(contentType);
		v1.setFilepath(path.toString());
		
	
//		metadata save
		return videoRepository.save(v1);
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public video getById(String videoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public video getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public video getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
