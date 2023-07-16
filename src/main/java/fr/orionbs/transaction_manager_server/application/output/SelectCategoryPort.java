package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.exception.UnknownCategoryPersistenceException;
import fr.orionbs.transaction_manager_server.domain.model.Category;

import java.util.List;

public interface SelectCategoryPort {
    List<Category> selectCategories();

    Category selectCategoryById(Integer categoryId) throws UnknownCategoryPersistenceException;
}
