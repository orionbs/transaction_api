package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryHistory {
    private Integer id;
    private Category category;
    private LocalDateTime milestone;
}
