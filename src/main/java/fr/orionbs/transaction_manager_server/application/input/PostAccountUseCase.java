package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.exception.FailedAccountException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager_server.domain.model.Account;

public interface PostAccountUseCase {
    Account postAccount(Account account) throws UnknownCurrencyException, FailedAccountException;
}
