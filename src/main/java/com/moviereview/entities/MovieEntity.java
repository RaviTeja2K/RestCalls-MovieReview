package com.moviereview.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "movie_info")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	
	@NotEmpty(message = "Movie name can not be empty")
	private String movieName;
	
	@NotEmpty(message = "Hero name can not be empty")
	private String heroName;
	
	@NotEmpty(message = "Heroine name can not be empty")
	private String heroineName;
	
	@NotEmpty(message = "Director name can not be empty")
	private String directorName;
	
	@NotEmpty(message = "Cameraman name can not be empty")
	private String cameramanName;
	
	@NotEmpty(message = "Music director name can not be empty")
	private String musicDirector;
}
