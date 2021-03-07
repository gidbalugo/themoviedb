package com.moviedb.api.service

import com.moviedb.api.entity.Movie
import com.moviedb.api.exception.MovieNotFoundException
import com.moviedb.api.repository.MovieRepository
import org.springframework.data.domain.Pageable
import spock.lang.Specification
import spock.lang.Subject

class MovieServiceSpec extends Specification {

    private MovieRepository movieRepository = Mock()

    @Subject
    private MovieService movieService = new MovieService(movieRepository)

    def "fetchMovieById should return the fetch movie based on Id"() {
        given: "test Id"
        UUID mockMovieId = UUID.randomUUID()

        and: "repository returns the corresponding movie"
        Movie mockMovie = Mock(Movie.class)
        movieRepository.findById(mockMovieId) >> Optional.of(mockMovie)

        when:
        Movie expectedMovie = movieService.fetchMovieById(mockMovieId)

        then: "returns the same movie fetched by repository"
        expectedMovie == mockMovie
    }

    def "fetchMovieById should throw MovieNotFoundException if no movie is found based on provided Id"() {
        given: "non existing movie id"
        UUID nonExistingMovieId = UUID.randomUUID()
        movieRepository.findById(nonExistingMovieId) >> Optional.empty()

        when:
        movieService.fetchMovieById(nonExistingMovieId)

        then: "method throws MovieNotFoundException"
        thrown(MovieNotFoundException.class)
    }

    def "fetchMovieById should invoke movieRepository to fetch movie by Id"() {
        given: "test Id"
        UUID mockMovieId = UUID.randomUUID()

        when:
        movieService.fetchMovieById(mockMovieId)

        then: "invokes repository to fetch movie based on the supplied id"
        1 * movieRepository.findById({ movieId ->
            movieId == mockMovieId
        }) >> Optional.of(Mock(Movie.class))
    }

    def "fetchAllMovies should invoke repository with paginated results"() {
        given: "test Pageable"
        Pageable mockPageable = Mock(Pageable.class)

        when:
        movieService.fetchAllMovies(mockPageable)

        then: "invokes repository to find all movies with the same pageable"
        1 * movieRepository.findAll({ pageable ->
            pageable == mockPageable
        })
    }
}
