package ru.xegex.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.xegex.alpha.entity.TransactionEntity;

import java.util.UUID;
import java.util.stream.Stream;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
    @Query("select t from TransactionEntity t")
    Stream<TransactionEntity> findAllStream();
}
