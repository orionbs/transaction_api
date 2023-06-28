package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrencyHistory {
    private Integer id;
    private Currency currency;
    private LocalDateTime milestone;
}
