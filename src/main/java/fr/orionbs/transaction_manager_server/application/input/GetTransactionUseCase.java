package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetTransactionUseCase {
    Page<Transaction> getTransactions(Pageable pageable);
}
