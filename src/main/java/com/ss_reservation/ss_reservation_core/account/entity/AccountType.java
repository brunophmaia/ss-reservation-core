package com.ss_reservation.ss_reservation_core.account.entity;

import jakarta.persistence.*;

@Entity
public class AccountType {

    public AccountType(){}

    public AccountType(String key, String description) {
        this.key = key;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String key;

    @Column(length = 150, nullable = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
