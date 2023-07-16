package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

@Data
public class Frequency {
    private Integer id;
    private FrequencyEnum frequencyEnum;
}
