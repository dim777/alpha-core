package tech.ineb.ats.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.ineb.ats.alpha.model.history.Quote;

import java.util.UUID;
import java.util.stream.Stream;

public interface QuoteRepository extends JpaRepository<Quote, UUID> {
    @Query("select q from Quote q")
    Stream<Quote> findAllStream();
}
