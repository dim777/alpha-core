package tech.ineb.svc.data.api.adapters;

import tech.ineb.lib.common.models.Quote;
import tech.ineb.lib.common.models.TimeFrame;

import java.time.LocalDate;
import java.util.List;

public interface AdapterServices {
  List<Quote> getSeriesByEquityCodeAndRange(String equityCode, TimeFrame timeFrame, LocalDate from, LocalDate till);
}
