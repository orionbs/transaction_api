package fr.orionbs.transaction_manager.adapter.output.persistence.category.mapper;

import fr.orionbs.transaction_manager.adapter.output.persistence.category.entity.CategoryEntity;
import fr.orionbs.transaction_manager.domain.model.Category;
import fr.orionbs.transaction_manager.domain.model.CategoryEnum;
import org.springframework.stereotype.Component;

@Component
public class CategoryPersistenceMapper {

    public Category toCategory(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setCategoryEnum(CategoryEnum.valueOf(categoryEntity.getValue()));
        return category;
    }

}
