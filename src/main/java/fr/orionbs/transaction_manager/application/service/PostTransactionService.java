package fr.orionbs.transaction_manager.application.service;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.category.exception.UnknownCategoryPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.frequency.exception.UnknownFrequencyPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.transaction.exception.FailedTransactionPersistenceException;
import fr.orionbs.transaction_manager.application.input.PostTransactionUseCase;
import fr.orionbs.transaction_manager.application.output.InsertTransactionPort;
import fr.orionbs.transaction_manager.application.output.SelectOwnerPort;
import fr.orionbs.transaction_manager.domain.exception.FailedTransactionException;
import fr.orionbs.transaction_manager.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostTransactionService implements PostTransactionUseCase {

    private final InsertTransactionPort insertTransactionPort;
    private final SelectOwnerPort selectOwnerPort;

    @Override
    public Transaction postTransaction(Transaction transaction) throws FailedTransactionException, UnknownAccountException, UnknownCategoryException, UnknownFrequencyException {
        transaction.setOwner(selectOwnerPort.selectOwner());
        try {
            return insertTransactionPort.insertTransaction(transaction);
        } catch (FailedTransactionPersistenceException e) {
            throw new FailedTransactionException();
        } catch (UnknownAccountPersistenceException e) {
            throw new UnknownAccountException();
        } catch (UnknownCategoryPersistenceException e) {
            throw new UnknownCategoryException();
        } catch (UnknownFrequencyPersistenceException e) {
            throw new UnknownFrequencyException();
        }
    }
}
