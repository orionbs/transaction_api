package fr.orionbs.transaction_manager_server.adapter.output.persistence.currency;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.mapper.CurrencyPersistenceMapper;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.repository.CurrencyRepository;
import fr.orionbs.transaction_manager_server.application.output.SelectCurrencyPort;
import fr.orionbs.transaction_manager_server.domain.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CurrencyPersistenceAdapter implements SelectCurrencyPort {

    private final CurrencyRepository currencyRepository;
    private final CurrencyPersistenceMapper currencyPersistenceMapper;

    @Override
    public List<Currency> selectCurrencies() {
        return currencyRepository
                .findAll()
                .stream()
                .map(currencyPersistenceMapper::toCurrency)
                .collect(Collectors.toList());
    }

    @Override
    public Currency selectCurrencyById(Integer currencyId) throws UnknownCurrencyPersistenceException {
        return currencyRepository
                .findById(currencyId)
                .map(currencyPersistenceMapper::toCurrency)
                .orElseThrow(UnknownCurrencyPersistenceException::new);
    }
}
