package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

@Data
public class Frequency {
    private Integer id;
    private FrequencyEnum frequencyEnum;
}
