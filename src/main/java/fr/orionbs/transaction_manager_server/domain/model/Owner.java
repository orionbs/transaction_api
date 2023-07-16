package fr.orionbs.transaction_manager_server.domain.model;

import lombok.Data;

@Data
public class Owner {
    private String id;
    private String email;
    private String fullName;
}
