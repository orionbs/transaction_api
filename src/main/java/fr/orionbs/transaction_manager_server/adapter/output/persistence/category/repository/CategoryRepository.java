package fr.orionbs.transaction_manager_server.adapter.output.persistence.category.repository;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
