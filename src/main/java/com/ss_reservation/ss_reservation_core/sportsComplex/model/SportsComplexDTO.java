package com.ss_reservation.ss_reservation_core.sportsComplex.model;

import com.ss_reservation.ss_reservation_core.common.util.Utility;

public class SportsComplexDTO {

    public String name;
    public String address;

    public boolean checkNullRequiredFields() {
        return Utility.isStringNullOrEmpty(this.name) || Utility.isStringNullOrEmpty(this.address);
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
