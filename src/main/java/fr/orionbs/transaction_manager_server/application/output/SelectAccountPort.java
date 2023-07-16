package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager_server.domain.model.Account;

import java.util.List;

public interface SelectAccountPort {
    List<Account> selectAccounts(String ownerId);

    Account selectAccountById(Integer accountId, String ownerId) throws UnknownAccountPersistenceException;
}
