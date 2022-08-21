package tech.ineb.lib.common.models.rest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QuoteSeriesRequest {
  private String equityCode;
  private String timeFrame;
  private LocalDate from;
  private LocalDate till;
}
