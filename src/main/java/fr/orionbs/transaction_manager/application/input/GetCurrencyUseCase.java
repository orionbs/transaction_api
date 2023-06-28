package fr.orionbs.transaction_manager.application.input;

import fr.orionbs.transaction_manager.domain.exception.UnknownCurrencyException;
import fr.orionbs.transaction_manager.domain.model.Currency;

import java.util.List;

public interface GetCurrencyUseCase {
    List<Currency> getCurrencies();

    Currency getCurrencyById(Integer currencyId) throws UnknownCurrencyException;
}
