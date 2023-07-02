package fr.orionbs.transaction_manager.application.output;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager.domain.model.Account;

import java.util.List;

public interface SelectAccountPort {
    List<Account> selectAccounts(String ownerId);

    Account selectAccountById(Integer accountId, String ownerId) throws UnknownAccountPersistenceException;
}
