package com.dotcapital.exception;


/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.exception */
public class FunctionalException extends RuntimeException {

    private final ErrorInput errorInput;

    public FunctionalException(ErrorInput errorInput) {
        super(errorInput.getTitle());
        this.errorInput = errorInput;
        if(this.errorInput.getSeverity() == null) {
            this.errorInput.setSeverity(ErrorSeverity.W);
        }
    }


    public ErrorInput getErrorInput() {
        return errorInput;
    }
}
