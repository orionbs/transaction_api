package fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.mapper;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.mapper.AccountPersistenceMapper;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.mapper.CategoryPersistenceMapper;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.mapper.FrequencyPersistenceMapper;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.owner.mapper.OwnerPersistenceMapper;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.entity.TransactionEntity;
import fr.orionbs.transaction_manager_server.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionPersistenceMapper {

    private final CategoryPersistenceMapper categoryPersistenceMapper;
    private final FrequencyPersistenceMapper frequencyPersistenceMapper;
    private final AccountPersistenceMapper accountPersistenceMapper;
    private final OwnerPersistenceMapper ownerPersistenceMapper;

    public Transaction toTransaction(TransactionEntity transactionEntity) {

        Transaction transaction = new Transaction();
        transaction.setId(transactionEntity.getId());
        transaction.setLabel(transactionEntity.getLabel());
        transaction.setDescription(transactionEntity.getDescription());
        transaction.setMilestone(transactionEntity.getMilestone().toLocalDateTime());
        transaction.setAmount(transactionEntity.getAmount());
        if (transactionEntity.getCategory() != null) {
            transaction.setCategory(categoryPersistenceMapper.toCategory(transactionEntity.getCategory()));
        }
        if (transactionEntity.getFrequency() != null) {
            transaction.setFrequency(frequencyPersistenceMapper.toFrequency(transactionEntity.getFrequency()));
        }
        if (transactionEntity.getAccount() != null) {
            transaction.setAccount(accountPersistenceMapper.toAccount(transactionEntity.getAccount()));
        }
        if (transactionEntity.getOwner() != null) {
            transaction.setOwner(ownerPersistenceMapper.toOwner(transactionEntity.getOwner()));
        }

        return transaction;

    }
}
