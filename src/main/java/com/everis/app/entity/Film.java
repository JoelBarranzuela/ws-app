package com.everis.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Film {
	
	private String id;
	private String title;
	private String description;
	private String director;
	private String producer;
	private String release_date;
	private String rt_score;

	
	
}
