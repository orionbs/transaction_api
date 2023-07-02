package fr.orionbs.transaction_manager.adapter.output.persistence.account;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.entity.AccountEntity;
import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.FailedAccountPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.account.mapper.AccountPersistenceMapper;
import fr.orionbs.transaction_manager.adapter.output.persistence.account.repository.AccountRepository;
import fr.orionbs.transaction_manager.adapter.output.persistence.currency.entity.CurrencyEntity;
import fr.orionbs.transaction_manager.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.currency.repository.CurrencyRepository;
import fr.orionbs.transaction_manager.application.output.InsertAccountPort;
import fr.orionbs.transaction_manager.application.output.SelectAccountPort;
import fr.orionbs.transaction_manager.domain.model.Account;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements InsertAccountPort, SelectAccountPort {

    private final AccountRepository accountRepository;
    private final CurrencyRepository currencyRepository;
    private final AccountPersistenceMapper accountPersistenceMapper;

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public Account insertAccount(Account account) throws UnknownCurrencyPersistenceException, FailedAccountPersistenceException {

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(account.getName());
        accountEntity.setDescription(account.getDescription());
        accountEntity.setOwnerId(account.getOwner().getId());

        CurrencyEntity currencyEntity = currencyRepository
                .findById(account.getCurrency().getId())
                .orElseThrow(UnknownCurrencyPersistenceException::new);

        accountEntity.setCurrency(currencyEntity);

        try {
            accountEntity = accountRepository.save(accountEntity);
        } catch (Throwable throwable) {
            throw new FailedAccountPersistenceException(throwable.getMessage(), throwable);
        }

        return accountPersistenceMapper.toAccount(accountEntity);

    }

    @Override
    @Transactional
    public List<Account> selectAccounts(String ownerId) {
        return accountRepository
                .findAccountEntitiesByOwnerId(ownerId)
                .stream()
                .map(accountPersistenceMapper::toAccount)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Account selectAccountById(Integer accountId, String ownerId) throws UnknownAccountPersistenceException {
        return accountRepository
                .findAccountEntityByIdAndOwnerId(accountId, ownerId)
                .map(accountPersistenceMapper::toAccount)
                .orElseThrow(UnknownAccountPersistenceException::new);
    }
}
