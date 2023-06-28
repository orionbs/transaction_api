package fr.orionbs.transaction_manager.adapter.input.api.currency.specification;


import fr.orionbs.transaction_manager.adapter.input.api.currency.data.CurrencyException;
import fr.orionbs.transaction_manager.adapter.input.api.currency.data.CurrencySelectionResponse;
import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
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

@Tag(name = "Currencies", description = "This part will help you to find the currency you need.")
@SecurityRequirement(name = "Google OAuth2")
@RequestMapping(path = "currencies")
public interface CurrencyApi {

    @Operation(summary = "Obtain all currencies")
    @ApiResponse(description = "Success, you obtain all currencies.", responseCode = "200")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    List<CurrencySelectionResponse> getCurrencies();

    @Operation(summary = "Obtain a currency by his id.")
    @ApiResponse(description = "Success, you obtain a currency.", responseCode = "200")
    @ApiResponse(description = "Failure, unknown category.", responseCode = "404", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CurrencyException.class))})
    @GetMapping(path = "/{currencyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    CurrencySelectionResponse getCurrencyById(@PathVariable Integer currencyId) throws UnknownCurrencyException;

    @ExceptionHandler(UnknownCurrencyException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    CurrencyException unknownCurrencyException(UnknownCurrencyException unknownCurrencyException);

}
