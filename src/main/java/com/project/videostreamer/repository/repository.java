package com.project.videostreamer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.videostreamer.entities.video;

@Repository
public interface repository extends JpaRepository<video, String>{
	

}
