package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.exception.FailedTransactionException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager_server.domain.model.Transaction;

public interface PostTransactionUseCase {
    Transaction postTransaction(Transaction transaction) throws FailedTransactionException, UnknownAccountException, UnknownCategoryException, UnknownFrequencyException;
}
