package fr.orionbs.transaction_manager.domain.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String email;
    private String fullName;
}
