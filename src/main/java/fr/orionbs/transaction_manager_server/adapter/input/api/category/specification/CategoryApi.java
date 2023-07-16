package fr.orionbs.transaction_manager_server.adapter.input.api.category.specification;


import fr.orionbs.transaction_manager_server.adapter.input.api.category.data.CategoryException;
import fr.orionbs.transaction_manager_server.adapter.input.api.category.data.GetCategoryResponse;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCategoryException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categories", description = "This part will help you to find the category you need.")
@SecurityRequirement(name = "Google OAuth2")
@RequestMapping(path = "categories")
public interface CategoryApi {

    @Operation(summary = "Obtain all categories")
    @ApiResponse(description = "Success, you obtain all categories.", responseCode = "200")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    List<GetCategoryResponse> getCategories(Authentication authentication);

    @Operation(summary = "Obtain a category by his id.")
    @ApiResponse(description = "Success, you obtain a category.", responseCode = "200")
    @ApiResponse(description = "Failure, unknown category.", responseCode = "404", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CategoryException.class))})
    @GetMapping(path = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    GetCategoryResponse getCategoryById(@PathVariable Integer categoryId) throws UnknownCategoryException;

    @ExceptionHandler(UnknownCategoryException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    CategoryException unknownCategoryException(UnknownCategoryException unknownCategoryException);

}
