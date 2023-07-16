package fr.orionbs.transaction_manager_server.adapter.input.api.account.specification;

import fr.orionbs.transaction_manager_server.adapter.input.api.account.data.AccountException;
import fr.orionbs.transaction_manager_server.adapter.input.api.account.data.GetAccountResponse;
import fr.orionbs.transaction_manager_server.adapter.input.api.account.data.PostAccountRequest;
import fr.orionbs.transaction_manager_server.adapter.input.api.account.data.PostAccountResponse;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.exception.FailedAccountPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager_server.domain.exception.FailedAccountException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownAccountException;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCurrencyException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Accounts", description = "This part will help you to manage your accounts.")
@SecurityRequirement(name = "Google OAuth2")
@RequestMapping(path = "accounts")
public interface AccountApi {

    @Operation(summary = "Obtain all accounts")
    @ApiResponse(description = "Success, you obtain all accounts", responseCode = "200")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    List<GetAccountResponse> getAccounts();

    @Operation(summary = "Obtain an account by his id.")
    @ApiResponse(description = "Success, you obtain a account.", responseCode = "200")
    @ApiResponse(description = "Failure, unknown account.", responseCode = "404", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountException.class))})
    @GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    GetAccountResponse getAccountById(@PathVariable Integer accountId) throws UnknownAccountException;

    @Operation(summary = "Create an account")
    @ApiResponse(description = "Success, you create an account.", responseCode = "201")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    PostAccountResponse postAccount(@RequestBody PostAccountRequest postAccountRequest) throws UnknownCurrencyPersistenceException, FailedAccountPersistenceException, UnknownCurrencyException, FailedAccountException;

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseStatus(code = HttpStatus.OK)
    AccountException unknownAccountException(UnknownAccountException unknownAccountException);

    @ExceptionHandler(FailedAccountException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    AccountException failedAccountException(FailedAccountException failedAccountException);

}
