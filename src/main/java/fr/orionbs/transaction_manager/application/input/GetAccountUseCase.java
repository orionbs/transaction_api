package fr.orionbs.transaction_manager.application.input;

import fr.orionbs.transaction_manager.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager.domain.model.Account;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface GetAccountUseCase {
    List<Account> getAccounts();

    Account getAccountById(Integer accountId) throws UnknownAccountException;
}
