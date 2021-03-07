package com.moviedb.api.controller;

import com.moviedb.api.entity.Movie;
import com.moviedb.api.exception.MovieNotFoundException;
import com.moviedb.api.service.MovieService;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController implements MovieOperations {

  private final MovieService movieService;

  public MoveController(MovieService movieService) {
    this.movieService = movieService;
  }

  @Override
  @ResponseBody
  public ResponseEntity<Movie> getById(String id) {

    try {
      Movie movie = movieService.fetchMovieById(UUID.fromString(id));
      return ResponseEntity.ok(movie);
    } catch (MovieNotFoundException | IllegalArgumentException e) {
      e.printStackTrace();
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<Page<Movie>> getMovies(Pageable pageable) {
    Page<Movie> pagedMovies = movieService.fetchAllMovies(pageable);
    return ResponseEntity.ok(pagedMovies);
  }

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody MovieDto movieDto) {
    Movie movie = Movie.initializeMovie(movieDto);
    movieService.save(movie);
  }
}
