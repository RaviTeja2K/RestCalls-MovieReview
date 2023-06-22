package com.moviereview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviereview.entities.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{

	@Query("select m.movieName from movie_info m")
	List<String> listOfMovieNames();
	
   MovieEntity	findByMovieName(String movieName);
}
