package fr.orionbs.transaction_manager.application.output;

import fr.orionbs.transaction_manager.domain.model.Owner;

public interface SelectOwnerPort {
    Owner selectOwner();
}
