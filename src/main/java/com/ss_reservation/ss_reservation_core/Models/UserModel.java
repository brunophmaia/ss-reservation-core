package com.ss_reservation.ss_reservation_core.Models;

public class UserModel {

    public UserModel(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    private Long id;

    private String name;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
