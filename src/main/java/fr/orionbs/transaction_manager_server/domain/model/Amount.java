package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Amount {
    private Integer id;
    private BigDecimal value;
    private LocalDateTime milestone;
}
