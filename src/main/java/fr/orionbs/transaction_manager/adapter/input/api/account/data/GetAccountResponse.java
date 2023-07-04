package fr.orionbs.transaction_manager.adapter.input.api.account.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetAccountResponse {
    private Integer id;
    private String name;
    private String description;
    private String currencyCode;
    private BigDecimal balance;
}
