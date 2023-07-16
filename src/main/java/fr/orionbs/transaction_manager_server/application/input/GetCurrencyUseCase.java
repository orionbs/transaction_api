package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager_server.domain.model.Currency;

import java.util.List;

public interface GetCurrencyUseCase {
    List<Currency> getCurrencies();

    Currency getCurrencyById(Integer currencyId) throws UnknownCurrencyException;
}
