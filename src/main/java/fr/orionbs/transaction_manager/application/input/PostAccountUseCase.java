package fr.orionbs.transaction_manager.application.input;

import fr.orionbs.transaction_manager.domain.exception.FailedAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager.domain.model.Account;
import org.springframework.security.core.Authentication;

public interface PostAccountUseCase {
    Account postAccount(Account account) throws UnknownCurrencyException, FailedAccountException;
}
