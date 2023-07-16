package fr.orionbs.transaction_manager_server.application.service;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.exception.UnknownCategoryPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.exception.UnknownFrequencyPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.exception.FailedTransactionPersistenceException;
import fr.orionbs.transaction_manager_server.application.input.PostTransactionUseCase;
import fr.orionbs.transaction_manager_server.application.output.InsertTransactionPort;
import fr.orionbs.transaction_manager_server.application.output.SelectOwnerPort;
import fr.orionbs.transaction_manager_server.domain.exception.FailedTransactionException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager_server.domain.model.Transaction;
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
