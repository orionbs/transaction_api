package fr.orionbs.transaction_manager.adapter.input.api.account.data;

import lombok.Data;

@Data
public class PostAccountResponse {
    private Integer id;
    private String name;
    private String description;
    private String currencyCode;
}
