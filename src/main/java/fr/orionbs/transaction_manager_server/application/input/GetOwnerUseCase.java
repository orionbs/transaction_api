package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.model.Owner;

public interface GetOwnerUseCase {
    Owner getOwner();
}
