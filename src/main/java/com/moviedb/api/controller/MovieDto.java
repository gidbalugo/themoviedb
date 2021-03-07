package com.moviedb.api.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieDto {

  private String title;
  private String overview;
  private String poster;
  private Integer voteAverage;
  private String releaseDate;
}
