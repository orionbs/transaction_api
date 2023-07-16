package fr.orionbs.transaction_manager_server.adapter.output.persistence.owner.mapper;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.owner.entity.OwnerEntity;
import fr.orionbs.transaction_manager_server.domain.model.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerPersistenceMapper {

    public Owner toOwner(OwnerEntity ownerEntity) {
        Owner owner = new Owner();
        owner.setId(ownerEntity.getId());
        owner.setEmail(ownerEntity.getEmail());
        owner.setFullName(ownerEntity.getFullName());
        return owner;
    }

}
