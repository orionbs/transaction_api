package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.exception.UnknownCurrencyPersistenceException;
import fr.orionbs.transaction_manager_server.domain.model.Currency;

import java.util.List;

public interface SelectCurrencyPort {
    List<Currency> selectCurrencies();

    Currency selectCurrencyById(Integer currencyId) throws UnknownCurrencyPersistenceException;
}
