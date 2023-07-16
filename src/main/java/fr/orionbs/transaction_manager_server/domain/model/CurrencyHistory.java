package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrencyHistory {
    private Integer id;
    private Currency currency;
    private LocalDateTime milestone;
}
