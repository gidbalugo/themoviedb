package com.moviedb.api.service;

import com.moviedb.api.entity.Movie;
import com.moviedb.api.exception.MovieNotFoundException;
import com.moviedb.api.repository.MovieRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Movie fetchMovieById(UUID id) throws MovieNotFoundException {
    Optional<Movie> optionalMovie = movieRepository.findById(id);

    return optionalMovie.orElseThrow(MovieNotFoundException::new);
  }
}
