package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

@Data
public class Currency {
    private Integer id;
    private CurrencyEnum currencyEnum;
}
