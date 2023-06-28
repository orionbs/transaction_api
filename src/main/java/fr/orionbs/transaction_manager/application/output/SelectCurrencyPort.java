package fr.orionbs.transaction_manager.application.output;

import fr.orionbs.transaction_manager.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager.domain.model.Currency;

import java.util.List;

public interface SelectCurrencyPort {
    List<Currency> selectCurrencies();

    Currency selectCurrencyById(Integer currencyId) throws UnknownCurrencyPersistenceException;
}
