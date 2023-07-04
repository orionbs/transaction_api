package fr.orionbs.transaction_manager.adapter.input.api.transaction;

import fr.orionbs.transaction_manager.adapter.input.api.transaction.data.PostTransactionRequest;
import fr.orionbs.transaction_manager.adapter.input.api.transaction.data.PostTransactionResponse;
import fr.orionbs.transaction_manager.adapter.input.api.transaction.mapper.TransactionApiMapper;
import fr.orionbs.transaction_manager.adapter.input.api.transaction.specification.TransactionApi;
import fr.orionbs.transaction_manager.application.input.PostTransactionUseCase;
import fr.orionbs.transaction_manager.domain.exception.FailedTransactionException;
import fr.orionbs.transaction_manager.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager.domain.model.Account;
import fr.orionbs.transaction_manager.domain.model.Category;
import fr.orionbs.transaction_manager.domain.model.Frequency;
import fr.orionbs.transaction_manager.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class TransactionApiAdapter implements TransactionApi {

    private final PostTransactionUseCase postTransactionUseCase;
    private final TransactionApiMapper transactionApiMapper;

    @Override
    public PostTransactionResponse postAccount(PostTransactionRequest postTransactionRequest) throws FailedTransactionException, UnknownCategoryException, UnknownAccountException, UnknownFrequencyException {
        Transaction transaction = new Transaction();
        transaction.setLabel(postTransactionRequest.getLabel());
        transaction.setDescription(postTransactionRequest.getDescription());
        transaction.setMilestone(LocalDateTime.parse(postTransactionRequest.getMilestone(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        transaction.setAmount(postTransactionRequest.getAmount());
        Category category = new Category();
        category.setId(postTransactionRequest.getCategoryId());
        transaction.setCategory(category);
        Frequency frequency = new Frequency();
        frequency.setId(postTransactionRequest.getFrequencyId());
        transaction.setFrequency(frequency);
        Account account = new Account();
        account.setId(postTransactionRequest.getAccountId());
        transaction.setAccount(account);
        return transactionApiMapper.toPostTransactionResponse(postTransactionUseCase.postTransaction(transaction));
    }
}
