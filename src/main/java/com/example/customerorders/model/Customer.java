package com.example.customerorders.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String email;
    private Timestamp createdAt;

    public Customer(UUID id, String name, String email, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
