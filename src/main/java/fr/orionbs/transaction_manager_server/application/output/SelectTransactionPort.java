package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.domain.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SelectTransactionPort {
    Page<Transaction> selectTransactions(String ownerId, Pageable pageable);

    List<Transaction> selectTransactionsByAccountId(Integer accountId, String ownerId);

    Transaction selectTransactionById(Integer transactionId, String ownerId);
}
