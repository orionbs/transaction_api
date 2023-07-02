package fr.orionbs.transaction_manager.adapter.output.persistence.account.repository;

import fr.orionbs.transaction_manager.adapter.output.persistence.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    List<AccountEntity> findAccountEntitiesByOwnerId(String ownerId);
    Optional<AccountEntity> findAccountEntityByIdAndOwnerId(Integer id, String ownerId);

}
