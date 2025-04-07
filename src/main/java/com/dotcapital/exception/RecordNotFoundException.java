package com.dotcapital.exception;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.exception */
public class RecordNotFoundException extends FunctionalException {

    public RecordNotFoundException(String message) {
        super(ErrorInput.builder().title(message).build());
    }
}
