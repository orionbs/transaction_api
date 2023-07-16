package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager_server.domain.model.Account;

import java.util.List;

public interface GetAccountUseCase {
    List<Account> getAccounts();

    Account getAccountById(Integer accountId) throws UnknownAccountException;
}
