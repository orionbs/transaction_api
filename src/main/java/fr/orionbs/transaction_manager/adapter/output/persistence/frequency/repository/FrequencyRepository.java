package fr.orionbs.transaction_manager.adapter.output.persistence.frequency.repository;

import fr.orionbs.transaction_manager.adapter.output.persistence.frequency.entity.FrequencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequencyRepository extends JpaRepository<FrequencyEntity, Integer> {
}
