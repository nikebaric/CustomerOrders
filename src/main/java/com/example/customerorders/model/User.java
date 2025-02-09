package com.example.customerorders.model;

import java.util.UUID;

public class User {

    public enum Role {
        ADMIN, USER
    }

    private UUID id;
    private String email;
    private String password;
    private Role role;


    public User(String email, String password, Role role) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public User(UUID id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
