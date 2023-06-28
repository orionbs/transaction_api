package fr.orionbs.transaction_manager.application.input;

import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager.domain.model.Category;

import java.util.List;

public interface GetCategoryUseCase {
    List<Category> getCategories();

    Category getCategoryById(Integer categoryId) throws UnknownCategoryException;
}
