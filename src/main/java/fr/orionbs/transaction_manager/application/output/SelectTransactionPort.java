package fr.orionbs.transaction_manager.application.output;

import fr.orionbs.transaction_manager.domain.model.Transaction;

import java.util.List;

public interface SelectTransactionPort {
    List<Transaction> selectTransactions(String ownerId);

    List<Transaction> selectTransactionsByAccountId(Integer accountId, String ownerId);

    Transaction selectTransactionById(Integer transactionId, String ownerId);
}
