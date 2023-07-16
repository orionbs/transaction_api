package fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.repository;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}
