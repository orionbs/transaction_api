package fr.orionbs.transaction_manager_server.adapter.input.api.transaction.specification;

import fr.orionbs.transaction_manager_server.adapter.input.api.transaction.data.PostTransactionRequest;
import fr.orionbs.transaction_manager_server.adapter.input.api.transaction.data.PostTransactionResponse;
import fr.orionbs.transaction_manager_server.domain.exception.FailedTransactionException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownFrequencyException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Transactions", description = "This part will help you to manage your transactions.")
@SecurityRequirement(name = "Google OAuth2")
@RequestMapping(path = "transactions")
public interface TransactionApi {

    @Operation(summary = "Create a transaction")
    @ApiResponse(description = "Success, you create a transaction.", responseCode = "201")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    PostTransactionResponse postAccount(@RequestBody PostTransactionRequest postTransactionRequest) throws FailedTransactionException, UnknownCategoryException, UnknownAccountException, UnknownFrequencyException;


}
