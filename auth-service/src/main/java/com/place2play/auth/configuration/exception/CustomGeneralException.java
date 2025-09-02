package com.place2play.auth.configuration.exception;

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
