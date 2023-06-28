package fr.orionbs.transaction_manager.application.output;

import fr.orionbs.transaction_manager.adapter.output.persistence.category.exception.UnknownCategoryPersistenceException;
import fr.orionbs.transaction_manager.domain.model.Category;

import java.util.List;

public interface SelectCategoryPort {
    List<Category> selectCategories();

    Category selectCategoryById(Integer categoryId) throws UnknownCategoryPersistenceException;
}
