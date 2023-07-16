package fr.orionbs.transaction_manager_server.adapter.input.api.account.mapper;

import fr.orionbs.transaction_manager_server.adapter.input.api.account.data.AccountException;
import fr.orionbs.transaction_manager_server.adapter.input.api.account.data.GetAccountResponse;
import fr.orionbs.transaction_manager_server.adapter.input.api.account.data.PostAccountResponse;
import fr.orionbs.transaction_manager_server.domain.model.Account;
import fr.orionbs.transaction_manager_server.domain.model.Currency;
import org.springframework.stereotype.Component;

@Component
public class AccountApiMapper {

    public GetAccountResponse toGetAccountResponse(Account account) {
        GetAccountResponse getAccountResponse = new GetAccountResponse();
        getAccountResponse.setId(account.getId());
        getAccountResponse.setName(account.getName());
        getAccountResponse.setDescription(account.getDescription());
        getAccountResponse.setBalance(account.getBalance());
        if (account.getCurrency() != null) {
            Currency currency = account.getCurrency();
            getAccountResponse.setCurrencyCode(currency.getCurrencyEnum().toString());
        }
        return getAccountResponse;
    }

    public PostAccountResponse toPostAccountResponse(Account account) {
        PostAccountResponse postAccountResponse = new PostAccountResponse();
        postAccountResponse.setId(account.getId());
        postAccountResponse.setName(account.getName());
        postAccountResponse.setDescription(account.getDescription());
        if (account.getCurrency() != null) {
            Currency currency = account.getCurrency();
            postAccountResponse.setCurrencyCode(currency.getCurrencyEnum().toString());
        }
        return postAccountResponse;
    }

    public AccountException toAccountException(Exception exception) {
        AccountException accountException = new AccountException();
        accountException.setMessage(exception.getMessage());
        return accountException;
    }

}
