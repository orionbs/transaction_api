package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FrequencyHistory {
    private Integer id;
    private Frequency frequency;
    private LocalDateTime milestone;
}
