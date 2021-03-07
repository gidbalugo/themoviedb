package com.moviedb.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {

  private static String DEFAULT_STRING_DATE_FORMAT = "yyyy-MM-dd";

  public static LocalDateTime dateFormatter(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_STRING_DATE_FORMAT);
    LocalDate ld = LocalDate.parse(date, formatter);
    return LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
  }
}
