package fr.orionbs.transaction_manager_server.application.service;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.exception.FailedAccountPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager_server.application.input.PostAccountUseCase;
import fr.orionbs.transaction_manager_server.application.output.InsertAccountPort;
import fr.orionbs.transaction_manager_server.application.output.SelectOwnerPort;
import fr.orionbs.transaction_manager_server.domain.exception.FailedAccountException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager_server.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostAccountService implements PostAccountUseCase {

    private final InsertAccountPort insertAccountPort;
    private final SelectOwnerPort selectOwnerPort;

    @Override
    public Account postAccount(Account account) throws UnknownCurrencyException, FailedAccountException {
        account.setOwner(selectOwnerPort.selectOwner());
        try {
            return insertAccountPort.insertAccount(account);
        } catch (UnknownCurrencyPersistenceException e) {
            throw new UnknownCurrencyException();
        } catch (FailedAccountPersistenceException e) {
            throw new FailedAccountException();
        }
    }

}
