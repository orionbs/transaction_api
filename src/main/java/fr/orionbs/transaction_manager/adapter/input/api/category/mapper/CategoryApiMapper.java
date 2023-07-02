package fr.orionbs.transaction_manager.adapter.input.api.category.mapper;

import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategoryException;
import fr.orionbs.transaction_manager.adapter.input.api.category.data.GetCategoryResponse;
import fr.orionbs.transaction_manager.domain.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryApiMapper {

    public GetCategoryResponse toCategorySelectionResponse(Category category) {
        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        getCategoryResponse.setId(category.getId());
        getCategoryResponse.setValue(category.getCategoryEnum().toString());
        return getCategoryResponse;
    }

    public CategoryException toCategoryException(Exception exception) {
        CategoryException categoryException = new CategoryException();
        categoryException.setMessage(exception.getMessage());
        return categoryException;
    }

}
