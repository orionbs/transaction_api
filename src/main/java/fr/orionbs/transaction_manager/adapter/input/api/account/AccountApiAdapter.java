package fr.orionbs.transaction_manager.adapter.input.api.account;

import fr.orionbs.transaction_manager.adapter.input.api.account.data.AccountException;
import fr.orionbs.transaction_manager.adapter.input.api.account.data.GetAccountResponse;
import fr.orionbs.transaction_manager.adapter.input.api.account.data.PostAccountRequest;
import fr.orionbs.transaction_manager.adapter.input.api.account.data.PostAccountResponse;
import fr.orionbs.transaction_manager.adapter.input.api.account.mapper.AccountApiMapper;
import fr.orionbs.transaction_manager.adapter.input.api.account.specification.AccountApi;
import fr.orionbs.transaction_manager.application.input.GetAccountUseCase;
import fr.orionbs.transaction_manager.application.input.PostAccountUseCase;
import fr.orionbs.transaction_manager.domain.exception.FailedAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager.domain.model.Account;
import fr.orionbs.transaction_manager.domain.model.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountApiAdapter implements AccountApi {

    private final GetAccountUseCase getAccountUseCase;
    private final PostAccountUseCase postAccountUseCase;
    private final AccountApiMapper accountApiMapper;

    @Override
    public List<GetAccountResponse> getAccounts() {
        return getAccountUseCase
                .getAccounts()
                .stream()
                .map(accountApiMapper::toGetAccountResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetAccountResponse getAccountById(Integer accountId) throws UnknownAccountException {
        return accountApiMapper.toGetAccountResponse(getAccountUseCase.getAccountById(accountId));
    }

    @Override
    public PostAccountResponse postAccount(PostAccountRequest postAccountRequest) throws UnknownCurrencyException, FailedAccountException {
        Account account = new Account();
        account.setName(postAccountRequest.getName());
        account.setDescription(postAccountRequest.getDescription());
        Currency currency = new Currency();
        currency.setId(postAccountRequest.getCurrencyId());
        account.setCurrency(currency);
        return accountApiMapper.toPostAccountResponse(postAccountUseCase.postAccount(account));
    }

    @Override
    public AccountException unknownAccountException(UnknownAccountException unknownAccountException) {
        return accountApiMapper.toAccountException(unknownAccountException);
    }

    @Override
    public AccountException failedAccountException(FailedAccountException failedAccountException) {
        return accountApiMapper.toAccountException(failedAccountException);
    }

}
