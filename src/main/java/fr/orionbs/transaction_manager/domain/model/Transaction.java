package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Transaction {

    private Integer id;
    private String description;
    private LocalDateTime milestone;
    private List<Amount> amounts = new ArrayList<>();
    private List<CategoryHistory> categories = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Frequency> frequencies = new ArrayList<>();
    private User user;

}
