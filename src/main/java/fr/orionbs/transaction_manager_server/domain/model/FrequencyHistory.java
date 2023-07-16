package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FrequencyHistory {
    private Integer id;
    private Frequency frequency;
    private LocalDateTime milestone;
}
