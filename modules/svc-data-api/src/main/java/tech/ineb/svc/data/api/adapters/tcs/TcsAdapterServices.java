package tech.ineb.svc.data.api.adapters.tcs;

import lombok.extern.slf4j.Slf4j;
import org.jooq.Configuration;
import org.springframework.stereotype.Service;
import tech.ineb.lib.common.entities.quotes.data.tables.daos.QuotesDao;
import tech.ineb.lib.common.models.Quote;
import tech.ineb.lib.common.models.TimeFrame;
import tech.ineb.svc.data.api.adapters.AdapterServices;

import java.time.LocalDate;
import java.util.List;

@Slf4j @Service
public class TcsAdapterServices implements AdapterServices {
  private final QuotesDao quotesDao;

  public TcsAdapterServices(Configuration configuration) {
    this.quotesDao = new QuotesDao(configuration);
  }

  @Override
  public List<Quote> getSeriesByEquityCodeAndRange(String equityCode, TimeFrame timeFrame, LocalDate from, LocalDate till) {
    quotesDao.insert();
    return null;
  }
}
