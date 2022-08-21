package ru.xegex.alpha.services;

import ru.xegex.alpha.model.Transaction;

public interface ExportTransactions {
    Transaction send(Transaction transactionDTO);
}
