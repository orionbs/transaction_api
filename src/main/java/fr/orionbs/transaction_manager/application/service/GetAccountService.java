package fr.orionbs.transaction_manager.application.service;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.category.exception.UnknownCategoryPersistenceException;
import fr.orionbs.transaction_manager.application.input.GetAccountUseCase;
import fr.orionbs.transaction_manager.application.output.SelectAccountPort;
import fr.orionbs.transaction_manager.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager.domain.model.Account;
import fr.orionbs.transaction_manager.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAccountService implements GetAccountUseCase {

    private final SelectAccountPort selectAccountPort;

    @Override
    public List<Account> getAccounts(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        return selectAccountPort.selectAccounts(jwt.getSubject());
    }

    @Override
    public Account getAccountById(Integer accountId, Authentication authentication) throws UnknownAccountException {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        try {
            return selectAccountPort.selectAccountById(accountId, jwt.getSubject());
        } catch (UnknownAccountPersistenceException e) {
            throw new UnknownAccountException();
        }
    }

}
