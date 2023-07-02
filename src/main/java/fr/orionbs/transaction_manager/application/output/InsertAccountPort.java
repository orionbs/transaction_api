package fr.orionbs.transaction_manager.application.output;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.FailedAccountPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager.domain.model.Account;

public interface InsertAccountPort {

    Account insertAccount(Account account) throws UnknownCurrencyPersistenceException, FailedAccountPersistenceException;
}
