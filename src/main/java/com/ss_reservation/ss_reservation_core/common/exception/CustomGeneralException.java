package com.ss_reservation.ss_reservation_core.common.exception;

import java.util.List;

public class CustomGeneralException extends RuntimeException {

    private List<String> values;

    public CustomGeneralException(String keyMessage) {
        super(keyMessage);
    }

    public CustomGeneralException(String keyMessage, List<String> values) {
        super(keyMessage);
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }
}
