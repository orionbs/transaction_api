package fr.orionbs.transaction_manager.adapter.input.api.category.mapper;

import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategoryException;
import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategorySelectionResponse;
import fr.orionbs.transaction_manager.domain.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryApiMapper {

    public CategorySelectionResponse toCategorySelectionResponse(Category category) {
        CategorySelectionResponse categorySelectionResponse = new CategorySelectionResponse();
        categorySelectionResponse.setId(category.getId());
        categorySelectionResponse.setValue(category.getCategoryEnum().toString());
        return categorySelectionResponse;
    }

    public CategoryException toCategoryException(Exception exception) {
        CategoryException categoryException = new CategoryException();
        categoryException.setMessage(exception.getMessage());
        return categoryException;
    }

}
