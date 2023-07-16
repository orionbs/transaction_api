package fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.entity.AccountEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.exception.UnknownAccountPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.repository.AccountRepository;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.entity.CategoryEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.exception.UnknownCategoryPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.repository.CategoryRepository;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.entity.FrequencyEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.exception.UnknownFrequencyPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.repository.FrequencyRepository;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.owner.entity.OwnerEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.entity.TransactionEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.exception.FailedTransactionPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.mapper.TransactionPersistenceMapper;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.repository.TransactionRepository;
import fr.orionbs.transaction_manager_server.application.output.InsertTransactionPort;
import fr.orionbs.transaction_manager_server.application.output.SelectTransactionPort;
import fr.orionbs.transaction_manager_server.domain.model.Transaction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionPersistenceAdapter implements InsertTransactionPort, SelectTransactionPort {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final FrequencyRepository frequencyRepository;
    private final AccountRepository accountRepository;
    private final TransactionPersistenceMapper transactionPersistenceMapper;

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public Transaction insertTransaction(Transaction transaction) throws UnknownCategoryPersistenceException, UnknownFrequencyPersistenceException, UnknownAccountPersistenceException, FailedTransactionPersistenceException {

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setLabel(transaction.getLabel());
        transactionEntity.setDescription(transaction.getDescription());
        transactionEntity.setMilestone(Timestamp.valueOf(transaction.getMilestone()));
        transactionEntity.setAmount(transaction.getAmount());

        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(transaction.getOwner().getId());
        ownerEntity.setEmail(transaction.getOwner().getEmail());
        ownerEntity.setFullName(transaction.getOwner().getFullName());
        transactionEntity.setOwner(ownerEntity);

        CategoryEntity categoryEntity = categoryRepository
                .findById(transaction.getCategory().getId())
                .orElseThrow(UnknownCategoryPersistenceException::new);

        transactionEntity.setCategory(categoryEntity);

        FrequencyEntity frequencyEntity = frequencyRepository
                .findById(transaction.getFrequency().getId())
                .orElseThrow(UnknownFrequencyPersistenceException::new);

        transactionEntity.setFrequency(frequencyEntity);

        AccountEntity accountEntity = accountRepository
                .findAccountEntityByIdAndOwnerId(transaction.getAccount().getId(), transaction.getOwner().getId())
                .orElseThrow(UnknownAccountPersistenceException::new);

        transactionEntity.setAccount(accountEntity);

        try {
            transactionEntity = transactionRepository.save(transactionEntity);
        } catch (Throwable throwable) {
            log.debug(throwable.getMessage());
            throw new FailedTransactionPersistenceException(throwable.getMessage(), throwable);
        }

        return transactionPersistenceMapper.toTransaction(transactionEntity);
    }

    @Override
    public List<Transaction> selectTransactions(String ownerId) {
        return null;
    }

    @Override
    public List<Transaction> selectTransactionsByAccountId(Integer accountId, String ownerId) {
        return null;
    }

    @Override
    public Transaction selectTransactionById(Integer transactionId, String ownerId) {
        return null;
    }
}
