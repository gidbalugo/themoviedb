package com.moviedb.api.repository;

import com.moviedb.api.entity.Movie;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public interface MovieRepository extends PagingAndSortingRepository<Movie, UUID> {

  Optional<Movie> findById(UUID id);
}
