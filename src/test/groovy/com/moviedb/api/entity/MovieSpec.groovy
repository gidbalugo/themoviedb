package com.moviedb.api.entity

import spock.lang.Specification

import java.time.LocalDateTime

class MovieSpec extends Specification {

    def "initializes with generated UUID"() {
        given:
        Movie movie = new Movie("test Title",
                "test overview",
                "test poster",
                1,
                LocalDateTime.now())

        expect: "movie with UUID id"
        movie.id != null
        movie.id instanceof UUID
    }
}
