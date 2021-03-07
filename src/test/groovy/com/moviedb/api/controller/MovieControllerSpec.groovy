package com.moviedb.api.controller

import com.moviedb.api.entity.Movie
import com.moviedb.api.exception.MovieNotFoundException
import com.moviedb.api.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Subject

class MovieControllerSpec extends Specification {

    private MovieService movieService = Mock()

    @Subject
    private MoveController moveController = new MoveController(movieService)

    def "getById should respond 404 status if id used is not valid UUID"() {
        given: "invalid UUID"
        String invalidUUID = "123"

        when:
        ResponseEntity<Movie> response = moveController.getById(invalidUUID)

        then: "responds NOT_FOUND"
        response.statusCode == HttpStatus.NOT_FOUND

        and: "service method is not invoked"
        0 * movieService.fetchMovieById(*_)
    }

    def "getById should invoke service method with the provided existing and valid UUID"() {
        given: "valid UUID"
        String validUUID = UUID.randomUUID().toString()

        when:
        ResponseEntity<Movie> response = moveController.getById(validUUID)

        then: "responds OK"
        response.statusCode == HttpStatus.OK

        and: "invokes service method with the UUID equivalent of provided id"
        1 * movieService.fetchMovieById({ id ->
            UUID.fromString(validUUID) == id
        }) >> Mock(Movie.class)
    }

    def "getById should respond the correct movie"() {
        given: "valid UUID"
        String validUUID = UUID.randomUUID().toString()

        and: "has an existing corresponding Movie"
        Movie mockedMovie = Mock(Movie.class)
        movieService.fetchMovieById(UUID.fromString(validUUID)) >> mockedMovie

        when:
        ResponseEntity<Movie> response = moveController.getById(validUUID)

        then: "responds OK"
        response.statusCode == HttpStatus.OK

        and: "responds the same entity returned by repository"
        response.body == mockedMovie
    }

    def "getById should respond NOT_FOUND if a provided UUID has no corresponding record"() {
        given: "valid UUID"
        String validUUID = UUID.randomUUID().toString()

        and: "has NO existing corresponding Movie"
        movieService.fetchMovieById(UUID.fromString(validUUID)) >> {
            throw new MovieNotFoundException()
        }

        when:
        ResponseEntity<Movie> response = moveController.getById(validUUID)

        then: "responds NOT_FOUND"
        response.statusCode == HttpStatus.NOT_FOUND
        response.body == null
    }
}
