package fr.orionbs.transaction_manager.application.input;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.FailedAccountPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager.domain.exception.FailedAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager.domain.model.Account;
import org.springframework.security.core.Authentication;

public interface PostAccountUseCase {
    Account postAccount(Account account, Authentication authentication) throws UnknownCurrencyException, FailedAccountException;
}
