package com.moviereview.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moviereview.entities.MovieEntity;
import com.moviereview.exceptions.MovieNotFoundException;
import com.moviereview.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	public String savePicture(@Valid MovieEntity movieEntity) {
		return movieRepository.save(movieEntity) != null ? "Movie saved Successfully" : "Movie failed to save";
	}

	public Page<MovieEntity> getMovies(Integer offset, Integer pagesize) {
		return movieRepository.findAll(PageRequest.of(offset, pagesize));
	}

	public List<String> getMovieNames() {
		return movieRepository.listOfMovieNames();
	}

	public MovieEntity getMovie(String moviename) throws MovieNotFoundException {
		MovieEntity movieEntity= movieRepository.findByMovieName(moviename);
		if(movieEntity!=null) {
			return movieEntity;
		}
		else {
			throw new MovieNotFoundException("Specified Movie is not registred ");
		}
	}
}