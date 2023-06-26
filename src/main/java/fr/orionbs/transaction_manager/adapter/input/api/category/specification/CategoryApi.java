package fr.orionbs.transaction_manager.adapter.input.api.category.specification;


import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategorySelectionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Categories", description = "This part will help you to find the category you need.")
@SecurityRequirement(name = "basic")
@RequestMapping(path = "categories")
public interface CategoryApi {

    @Operation(summary = "Obtain all categories")
    @ApiResponse(description = "Success, you obtain all categories.", responseCode = "200")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    List<CategorySelectionResponse> getCategories();

    @Operation(summary = "Obtain a category by his id.")
    @ApiResponse(description = "Success, you obtain a category.", responseCode = "200")
    @GetMapping(path = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    CategorySelectionResponse getCategoryById(@PathVariable Integer categoryId);

}
