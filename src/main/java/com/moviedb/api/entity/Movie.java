package com.moviedb.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Movie implements Serializable {

  @Id private UUID id;

  @Getter private String title;

  @Getter private String overview;

  @Getter private String poster;

  @Getter private Integer voteAverage;

  @Getter private LocalDateTime releaseDate;

  Movie(
      String title,
      String overview,
      String poster,
      Integer voteAverage,
      LocalDateTime releaseDate) {
    this.id = UUID.randomUUID();
    this.title = title;
    this.overview = overview;
    this.poster = poster;
    this.voteAverage = voteAverage;
    this.releaseDate = releaseDate;
  }
}
