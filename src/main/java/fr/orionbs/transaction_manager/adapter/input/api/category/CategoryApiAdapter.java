package fr.orionbs.transaction_manager.adapter.input.api.category;

import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategorySelectionResponse;
import fr.orionbs.transaction_manager.adapter.input.api.category.specification.CategoryApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CategoryApiAdapter implements CategoryApi {
    @Override
    public List<CategorySelectionResponse> getCategories(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        log.info(jwt.getTokenValue());
        return List.of(new CategorySelectionResponse());
    }

    @Override
    public CategorySelectionResponse getCategoryById(Integer categoryId) {
        return new CategorySelectionResponse();
    }
}
