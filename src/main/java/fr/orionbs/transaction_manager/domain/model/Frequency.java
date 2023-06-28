package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Frequency {
    private Integer id;
    private FrequencyEnum frequencyEnum;
    private LocalDateTime milestone;
}
