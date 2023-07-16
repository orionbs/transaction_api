package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.exception.FailedAccountPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager_server.domain.model.Account;

public interface InsertAccountPort {

    Account insertAccount(Account account) throws UnknownCurrencyPersistenceException, FailedAccountPersistenceException;
}
