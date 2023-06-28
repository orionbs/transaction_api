package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;
    private CategoryEnum categoryEnum;
    private LocalDateTime milestone;
}
