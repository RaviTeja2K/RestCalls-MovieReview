package com.moviereview.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.entities.MovieEntity;
import com.moviereview.exceptions.MovieNotFoundException;
import com.moviereview.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/savemovie")
	public String saveMovie(@RequestBody @Valid MovieEntity movieEntity) {
		return movieService.savePicture(movieEntity);
	}

	@GetMapping("/listofmovies/{offset}/{pagesize}")
	public Page<MovieEntity> movies(@PathVariable Integer offset,@PathVariable Integer pagesize) {
		return movieService.getMovies(offset,pagesize);
	}

	@GetMapping("/listofmovienames")
	public List<String> moviesNames() {
		return movieService.getMovieNames();
	}
	
	@GetMapping("/movie/{moviename}")
	public MovieEntity movie(@PathVariable String moviename) throws MovieNotFoundException {
		return movieService.getMovie(moviename);
	}
	
}
