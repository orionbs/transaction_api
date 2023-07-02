package fr.orionbs.transaction_manager.adapter.input.api.account.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostAccountRequest {
    @NotBlank(message = "{post_account_name_not-blank}")
    private String name;
    @NotBlank(message = "{post_account_description_not-blank}")
    private String description;
    @NotNull(message = "{post_account_currency_not-null}")
    private Currency currency;

    @Data
    public class Currency {
        @NotNull(message = "{post_account_currency_id_not-null}")
        private Integer id;
    }

}
