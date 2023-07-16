package fr.orionbs.transaction_manager_server.application.service;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager_server.application.input.GetAccountUseCase;
import fr.orionbs.transaction_manager_server.application.output.SelectAccountPort;
import fr.orionbs.transaction_manager_server.application.output.SelectOwnerPort;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager_server.domain.model.Account;
import fr.orionbs.transaction_manager_server.domain.model.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAccountService implements GetAccountUseCase {

    private final SelectAccountPort selectAccountPort;
    private final SelectOwnerPort selectOwnerPort;

    @Override
    public List<Account> getAccounts() {
        Owner owner = selectOwnerPort.selectOwner();
        return selectAccountPort.selectAccounts(owner.getId());
    }

    @Override
    public Account getAccountById(Integer accountId) throws UnknownAccountException {
        Owner owner = selectOwnerPort.selectOwner();
        try {
            return selectAccountPort.selectAccountById(accountId, owner.getId());
        } catch (UnknownAccountPersistenceException e) {
            throw new UnknownAccountException();
        }
    }

}
