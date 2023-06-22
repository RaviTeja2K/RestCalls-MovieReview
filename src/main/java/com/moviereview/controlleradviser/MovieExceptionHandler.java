package com.moviereview.controlleradviser;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.moviereview.exceptions.MovieNotFoundException;

@RestControllerAdvice
public class MovieExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> movieValidationException(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<String, String>();
		exception.getBindingResult()
		                 .getFieldErrors()
				         .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
		return errorMap;
	}

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MovieNotFoundException.class)
	public Map<String, String> noMovieFound(MovieNotFoundException exception) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("Error Message", exception.getMessage());
		return errorMap;
	}

}