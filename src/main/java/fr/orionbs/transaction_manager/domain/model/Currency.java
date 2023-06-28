package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Currency {
    private Integer id;
    private CurrencyEnum currencyEnum;
    private LocalDateTime milestone;
}
