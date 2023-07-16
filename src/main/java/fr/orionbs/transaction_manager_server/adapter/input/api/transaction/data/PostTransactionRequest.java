package fr.orionbs.transaction_manager_server.adapter.input.api.transaction.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostTransactionRequest {
    @NotBlank(message = "{post_transaction_label_not-blank}")
    private String label;
    @NotBlank(message = "{post_transaction_description_not-blank}")
    private String description;
    @Pattern(regexp = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$", message = "{post_transaction_milestone_pattern}")
    private String milestone;
    @NotNull(message = "{post_transaction_amount_not-null}")
    private BigDecimal amount;
    @NotNull(message = "{post_account_currency_id_not-null}")
    private Integer categoryId;
    @NotNull(message = "{post_transaction_frequency_id_not-null}")
    private Integer frequencyId;
    @NotNull(message = "{post_transaction_account_id_not-null}")
    private Integer accountId;

}
