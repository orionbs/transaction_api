package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FrequencyType {
    private Integer id;
    private FrequencyEnum frequencyEnum;
}
