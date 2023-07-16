package fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "frequency")
@Data
public class FrequencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;
    
}
