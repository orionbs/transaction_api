package fr.orionbs.transaction_manager.application.service;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.FailedAccountPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager.application.input.PostAccountUseCase;
import fr.orionbs.transaction_manager.application.output.InsertAccountPort;
import fr.orionbs.transaction_manager.domain.exception.FailedAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager.domain.model.Account;
import fr.orionbs.transaction_manager.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostAccountService implements PostAccountUseCase {

    private final InsertAccountPort insertAccountPort;

    @Override
    public Account postAccount(Account account, Authentication authentication) throws UnknownCurrencyException, FailedAccountException {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        User user = new User();
        user.setId(jwt.getSubject());
        account.setOwner(user);
        try {
            return insertAccountPort.insertAccount(account);
        } catch (UnknownCurrencyPersistenceException e) {
            throw new UnknownCurrencyException();
        } catch (FailedAccountPersistenceException e) {
            throw new FailedAccountException();
        }
    }
}
