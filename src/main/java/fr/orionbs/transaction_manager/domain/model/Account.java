package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private Integer id;
    private String name;
    private String description;
    private Currency currency;
    private List<Transaction> transactions = new ArrayList<>();
    private User owner;
}
