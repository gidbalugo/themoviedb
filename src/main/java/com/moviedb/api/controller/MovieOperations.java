package com.moviedb.api.controller;

import com.moviedb.api.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface MovieOperations {

  @GetMapping("/movie/{id}")
  ResponseEntity<Movie> getById(@PathVariable String id);

  @GetMapping("/movie")
  ResponseEntity<Page<Movie>> getMovies(Pageable pageable);
}
