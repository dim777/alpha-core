package ru.xegex.alpha.data;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.xegex.alpha.model.Quote;
import ru.xegex.alpha.repository.TransactionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultQuoteService implements QuoteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultQuoteService.class);
    private static final ModelMapper MAPPER = new ModelMapper();

    private final TransactionRepository quoteRepository;

    @Override
    public List<Quote> findAllUnprocessed() {
        return quoteRepository.findAllByProcessed(false)
                .map(this::map2QuoteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Quote> saveAll(List<Quote> quoteDTOs) {
        List<Quote> quotes = quoteDTOs.stream()
                .map(this::map2Quote)
                .collect(Collectors.toList());
        List<Quote> savedQuotes = quoteRepository.saveAll(quotes);
        return savedQuotes.stream().map(this::map2QuoteDTO)
                .collect(Collectors.toList());
    }

    private Quote map2Quote(Quote quoteDTO) {
        Quote quote = MAPPER.map(quoteDTO, Quote.class);
        LOGGER.debug("Mapped Quote -> Quote = '{}'", quote);
        return quote;
    }

    private Quote map2QuoteDTO(Quote q) {
        Quote quoteDTO = MAPPER.map(q, Quote.class);
        LOGGER.debug("Mapped Quote -> Quote = '{}'", quoteDTO);
        return quoteDTO;
    }
}
