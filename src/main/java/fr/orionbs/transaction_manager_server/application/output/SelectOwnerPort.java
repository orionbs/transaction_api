package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.domain.model.Owner;

public interface SelectOwnerPort {
    Owner selectOwner();
}
