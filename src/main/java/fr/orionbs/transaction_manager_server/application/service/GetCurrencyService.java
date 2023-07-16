package fr.orionbs.transaction_manager_server.application.service;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager_server.application.input.GetCurrencyUseCase;
import fr.orionbs.transaction_manager_server.application.output.SelectCurrencyPort;
import fr.orionbs.transaction_manager_server.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager_server.domain.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCurrencyService implements GetCurrencyUseCase {

    private final SelectCurrencyPort selectCurrencyPort;

    @Override
    public List<Currency> getCurrencies() {
        return selectCurrencyPort
                .selectCurrencies()
                .stream()
                .sorted(Comparator.comparing(Currency::getCurrencyEnum))
                .collect(Collectors.toList());
    }

    @Override
    public Currency getCurrencyById(Integer currencyId) throws UnknownCurrencyException {
        try {
            return selectCurrencyPort.selectCurrencyById(currencyId);
        } catch (UnknownCurrencyPersistenceException e) {
            throw new UnknownCurrencyException();
        }
    }
}
