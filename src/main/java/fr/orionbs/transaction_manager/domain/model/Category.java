package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private CategoryEnum categoryEnum;
}
