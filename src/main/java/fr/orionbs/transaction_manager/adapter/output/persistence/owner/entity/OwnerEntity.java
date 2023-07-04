package fr.orionbs.transaction_manager.adapter.output.persistence.owner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class OwnerEntity {
    @Column(name = "owner_id")
    private String id;
    @Column(name = "owner_email")
    private String email;
    @Column(name = "owner_full_name")
    private String fullName;
}
