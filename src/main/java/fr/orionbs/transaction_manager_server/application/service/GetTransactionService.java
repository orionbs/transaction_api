package fr.orionbs.transaction_manager_server.application.service;

import fr.orionbs.transaction_manager_server.application.input.GetTransactionUseCase;
import fr.orionbs.transaction_manager_server.application.output.SelectOwnerPort;
import fr.orionbs.transaction_manager_server.application.output.SelectTransactionPort;
import fr.orionbs.transaction_manager_server.domain.model.Owner;
import fr.orionbs.transaction_manager_server.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTransactionService implements GetTransactionUseCase {

    private final SelectOwnerPort selectOwnerPort;
    private final SelectTransactionPort selectTransactionPort;

    @Override
    public Page<Transaction> getTransactions(Pageable pageable) {
        Owner owner = selectOwnerPort.selectOwner();
        return selectTransactionPort.selectTransactions(owner.getId(), pageable);
    }
}
