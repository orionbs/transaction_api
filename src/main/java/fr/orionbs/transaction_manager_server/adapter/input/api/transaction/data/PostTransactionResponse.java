package fr.orionbs.transaction_manager_server.adapter.input.api.transaction.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostTransactionResponse {
    private String label;
    private String description;
    private String milestone;
    private BigDecimal amount;
    private String category;
    private String frequency;
    private String account;
}
