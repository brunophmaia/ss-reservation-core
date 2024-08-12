package com.ss_reservation.ss_reservation_core.account.model;

import com.ss_reservation.ss_reservation_core.common.util.Utility;

import java.util.Date;

public class AccountDTO {

    private String name;
    private String lastName;
    private Date birthDate;
    private char gender;
    private String email;
    private String password;
    private String phone;
    private String emailCode;

    public boolean checkNullRequiredFields(){
        return (Utility.isStringNullOrEmpty(this.name) ||
               Utility.isStringNullOrEmpty(this.lastName) ||
               this.birthDate == null ||
               !Character.isLetter(this.gender) ||
               Utility.isStringNullOrEmpty(this.email) ||
               Utility.isStringNullOrEmpty(this.password) ||
               Utility.isStringNullOrEmpty(this.phone) ||
               Utility.isStringNullOrEmpty(this.emailCode));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }
}
