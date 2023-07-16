package fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.repository;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.entity.FrequencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequencyRepository extends JpaRepository<FrequencyEntity, Integer> {
}
