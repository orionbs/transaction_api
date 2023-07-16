package fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.repository;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {
}
