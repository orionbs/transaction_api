package fr.orionbs.transaction_manager.adapter.input.api.category;

import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategoryException;
import fr.orionbs.transaction_manager.adapter.input.api.category.data.CategorySelectionResponse;
import fr.orionbs.transaction_manager.adapter.input.api.category.mapper.CategoryApiMapper;
import fr.orionbs.transaction_manager.adapter.input.api.category.specification.CategoryApi;
import fr.orionbs.transaction_manager.application.input.GetCategoryUseCase;
import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryApiAdapter implements CategoryApi {

    private final GetCategoryUseCase getCategoryUseCase;
    private final CategoryApiMapper categoryApiMapper;

    @Override
    public List<CategorySelectionResponse> getCategories(Authentication authentication) {
        return getCategoryUseCase
                .getCategories()
                .stream()
                .map(categoryApiMapper::toCategorySelectionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategorySelectionResponse getCategoryById(Integer categoryId) throws UnknownCategoryException {
        return categoryApiMapper.toCategorySelectionResponse(getCategoryUseCase.getCategoryById(categoryId));
    }

    @Override
    public CategoryException unknownCategoryException(UnknownCategoryException unknownCategoryException) {
        return categoryApiMapper.toCategoryException(unknownCategoryException);
    }

}
