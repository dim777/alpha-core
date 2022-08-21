package ru.xegex.alpha.data;

import ru.xegex.alpha.model.Quote;

import java.util.List;

public interface QuoteService {
    List<Quote> findAllUnprocessed();
    List<Quote> saveAll(List<Quote> quotes);
}
