package fr.orionbs.transaction_manager.adapter.output.persistence.category;

import fr.orionbs.transaction_manager.adapter.output.persistence.category.exception.UnknownCategoryPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.category.mapper.CategoryPersistenceMapper;
import fr.orionbs.transaction_manager.adapter.output.persistence.category.repository.CategoryRepository;
import fr.orionbs.transaction_manager.application.output.SelectCategoryPort;
import fr.orionbs.transaction_manager.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements SelectCategoryPort {

    private final CategoryRepository categoryRepository;
    private final CategoryPersistenceMapper categoryPersistenceMapper;

    @Override
    public List<Category> selectCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryPersistenceMapper::toCategory)
                .collect(Collectors.toList());
    }

    @Override
    public Category selectCategoryById(Integer categoryId) throws UnknownCategoryPersistenceException {
        return categoryRepository
                .findById(categoryId)
                .map(categoryPersistenceMapper::toCategory)
                .orElseThrow(UnknownCategoryPersistenceException::new);
    }
}
