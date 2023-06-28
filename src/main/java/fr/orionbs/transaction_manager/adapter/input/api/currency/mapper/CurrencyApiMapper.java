package fr.orionbs.transaction_manager.adapter.input.api.currency.mapper;

import fr.orionbs.transaction_manager.adapter.input.api.currency.data.CurrencyException;
import fr.orionbs.transaction_manager.adapter.input.api.currency.data.CurrencySelectionResponse;
import fr.orionbs.transaction_manager.domain.model.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyApiMapper {

    public CurrencySelectionResponse toCurrencySelectionResponse(Currency currency) {
        CurrencySelectionResponse currencySelectionResponse = new CurrencySelectionResponse();
        currencySelectionResponse.setId(currency.getId());
        currencySelectionResponse.setValue(currency.getCurrencyEnum().toString());
        return currencySelectionResponse;
    }

    public CurrencyException toCurrencyException(Exception exception) {
        CurrencyException currencyException = new CurrencyException();
        currencyException.setMessage(exception.getMessage());
        return currencyException;
    }

}
