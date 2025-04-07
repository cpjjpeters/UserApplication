package com.dotcapital.exception;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.exception */
public enum ErrorSeverity {
    E("Error"),
    F("Fatal"),
    W("Warning");

    private String value;

    ErrorSeverity(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }


}
