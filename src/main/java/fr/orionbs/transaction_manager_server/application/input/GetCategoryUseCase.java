package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager_server.domain.model.Category;

import java.util.List;

public interface GetCategoryUseCase {
    List<Category> getCategories();

    Category getCategoryById(Integer categoryId) throws UnknownCategoryException;
}
