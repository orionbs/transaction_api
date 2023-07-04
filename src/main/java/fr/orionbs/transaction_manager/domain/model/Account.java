package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private Integer id;
    private String name;
    private String description;
    private Currency currency;
    private List<Transaction> transactions = new ArrayList<>();
    private Owner owner;
    private BigDecimal balance;
}
