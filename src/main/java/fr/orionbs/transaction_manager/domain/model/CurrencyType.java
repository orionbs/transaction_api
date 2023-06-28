package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

@Data
public class CurrencyType {
    private Integer id;
    private CurrencyEnum currencyEnum;
}
