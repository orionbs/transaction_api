package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction {
    private Integer id;
    private String label;
    private String description;
    private LocalDateTime milestone;
    private BigDecimal amount;
    private Category category;
    private Frequency frequency;
    private Account account;
    private Owner owner;
}
