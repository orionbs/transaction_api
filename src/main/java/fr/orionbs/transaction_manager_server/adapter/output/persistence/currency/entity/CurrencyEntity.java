package fr.orionbs.transaction_manager_server.adapter.output.persistence.currency.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "currency")
@Data
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

}
