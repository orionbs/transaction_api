package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryHistory {
    private Integer id;
    private Category category;
    private LocalDateTime milestone;
}
