package fr.orionbs.transaction_manager.adapter.output.persistence.account.mapper;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.entity.AccountEntity;
import fr.orionbs.transaction_manager.adapter.output.persistence.currency.mapper.CurrencyPersistenceMapper;
import fr.orionbs.transaction_manager.domain.model.Account;
import fr.orionbs.transaction_manager.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPersistenceMapper {

    private final CurrencyPersistenceMapper currencyPersistenceMapper;

    public Account toAccount(AccountEntity accountEntity) {
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setName(accountEntity.getName());
        account.setDescription(accountEntity.getDescription());
        if (accountEntity.getCurrency() != null) {
            account.setCurrency(currencyPersistenceMapper.toCurrency(accountEntity.getCurrency()));
        }
        User user = new User();
        user.setId(accountEntity.getOwnerId());
        account.setOwner(user);
        return account;
    }

}
