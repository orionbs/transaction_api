package fr.orionbs.transaction_manager_server.adapter.output.persistence.category.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

}
