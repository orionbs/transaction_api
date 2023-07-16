package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private CategoryEnum categoryEnum;
}
