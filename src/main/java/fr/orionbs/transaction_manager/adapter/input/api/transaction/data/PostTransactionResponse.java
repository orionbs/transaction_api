package fr.orionbs.transaction_manager.adapter.input.api.transaction.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostTransactionResponse {
    private String label;
    private String description;
    private String milestone;
    private BigDecimal amount;
    private Category category = new Category();
    private Frequency frequency = new Frequency();
    private Account account = new Account();

    @Data
    public class Category {
        private Integer id;
    }

    @Data
    public class Frequency {
        private Integer id;
    }

    @Data
    public class Account {
        private Integer id;
    }

}
