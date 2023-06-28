package fr.orionbs.transaction_manager.adapter.input.api.currency;

import fr.orionbs.transaction_manager.adapter.input.api.currency.data.CurrencyException;
import fr.orionbs.transaction_manager.adapter.input.api.currency.data.CurrencySelectionResponse;
import fr.orionbs.transaction_manager.adapter.input.api.currency.mapper.CurrencyApiMapper;
import fr.orionbs.transaction_manager.adapter.input.api.currency.specification.CurrencyApi;
import fr.orionbs.transaction_manager.application.input.GetCurrencyUseCase;
import fr.orionbs.transaction_manager.domain.exception.UnknownCategoryException;
import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CurrencyApiAdapter implements CurrencyApi {

    private final GetCurrencyUseCase getCurrencyUseCase;
    private final CurrencyApiMapper currencyApiMapper;

    @Override
    public List<CurrencySelectionResponse> getCurrencies() {
        return getCurrencyUseCase
                .getCurrencies()
                .stream()
                .map(currencyApiMapper::toCurrencySelectionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CurrencySelectionResponse getCurrencyById(Integer currencyId) throws UnknownCurrencyException {
        return currencyApiMapper.toCurrencySelectionResponse(getCurrencyUseCase.getCurrencyById(currencyId));
    }

    @Override
    public CurrencyException unknownCurrencyException(UnknownCurrencyException unknownCurrencyException) {
        return currencyApiMapper.toCurrencyException(unknownCurrencyException);
    }

}
