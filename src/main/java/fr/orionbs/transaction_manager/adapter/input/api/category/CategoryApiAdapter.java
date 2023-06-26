package fr.orionbs.transaction_manager.adapter.input.api.category;

import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategorySelectionResponse;
import fr.orionbs.transaction_manager.adapter.input.api.category.specification.CategoryApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApiAdapter implements CategoryApi {
    @Override
    public List<CategorySelectionResponse> getCategories() {
        return List.of(new CategorySelectionResponse());
    }

    @Override
    public CategorySelectionResponse getCategoryById(Integer categoryId) {
        return new CategorySelectionResponse();
    }
}
