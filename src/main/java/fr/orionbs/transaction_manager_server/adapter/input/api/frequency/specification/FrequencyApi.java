package fr.orionbs.transaction_manager_server.adapter.input.api.frequency.specification;


import fr.orionbs.transaction_manager_server.adapter.input.api.frequency.data.FrequencyException;
import fr.orionbs.transaction_manager_server.adapter.input.api.frequency.data.FrequencySelectionResponse;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownFrequencyException;
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

@Tag(name = "Frequencies", description = "This part will help you to find the frequency you need.")
@SecurityRequirement(name = "Google OAuth2")
@RequestMapping(path = "frequencies")
public interface FrequencyApi {

    @Operation(summary = "Obtain all frequencies")
    @ApiResponse(description = "Success, you obtain all frequencies.", responseCode = "200")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    List<FrequencySelectionResponse> getFrequencies();

    @Operation(summary = "Obtain a frequency by his id.")
    @ApiResponse(description = "Success, you obtain a frequency.", responseCode = "200")
    @ApiResponse(description = "Failure, unknown frequency.", responseCode = "404", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FrequencyException.class))})
    @GetMapping(path = "/{frequencyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    FrequencySelectionResponse getFrequencyById(@PathVariable Integer frequencyId) throws UnknownFrequencyException;

    @ExceptionHandler(UnknownFrequencyException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    FrequencyException unknownFrequencyException(UnknownFrequencyException unknownFrequencyException);

}
