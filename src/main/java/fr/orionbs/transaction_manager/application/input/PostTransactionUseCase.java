package fr.orionbs.transaction_manager.application.input;

import fr.orionbs.transaction_manager.domain.exception.FailedTransactionException;
import fr.orionbs.transaction_manager.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager.domain.model.Transaction;

public interface PostTransactionUseCase {
    Transaction postTransaction(Transaction transaction) throws FailedTransactionException, UnknownAccountException, UnknownCategoryException, UnknownFrequencyException;
}
