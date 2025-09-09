package com.place2play.sportsComplex.model.dto;

import com.place2play.sportsComplex.utility.TypeUtil;

public class SportsComplexDTO {

    public String name;
    public String address;

    public boolean checkNullRequiredFields() {
        return TypeUtil.isStringNullOrEmpty(this.name) || TypeUtil.isStringNullOrEmpty(this.address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
