package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.domain.model.Transaction;

import java.util.List;

public interface SelectTransactionPort {
    List<Transaction> selectTransactions(String ownerId);

    List<Transaction> selectTransactionsByAccountId(Integer accountId, String ownerId);

    Transaction selectTransactionById(Integer transactionId, String ownerId);
}
