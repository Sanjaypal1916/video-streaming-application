package com.project.videostreamer.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class course {

	@Id
	private String id;
	private String title;
	
//	@OneToMany(mappedBy ="course")
//	private List<video> list = new ArrayList<>();
	
}
