package ru.xegex.alpha.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.xegex.alpha.model.Transaction;

@Service
@Transactional
public class FileExportTransactions implements ExportTransactions {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileExportTransactions.class);

    @Override
    public Transaction send(Transaction transactionDTO) {
        LOGGER.debug("Try to send transactionDTO='{}'", transactionDTO);
        return null;
    }
}
