package com.project.videostreamer.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class video {
	
	@Id
	private String videoId;
	private String title;
	private String description;
	private String contentType;
	private String filepath;
	
//	@ManyToOne
//	private course videoCourse;
	

}
