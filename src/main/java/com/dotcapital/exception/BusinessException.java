package com.dotcapital.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.Optional;

/* carlpeters created on 09/04/2025 inside the package - com.dotcapital.exception */

public class BusinessException extends RuntimeException {

    String title;

    String returnCode;

     String subReturnCode;

    HttpStatus httpStatus;

    ErrorSeverity severity;



    public BusinessException(String title, String returnCode, String subReturnCode, ErrorSeverity severity) {

        this(title, HttpStatus.BAD_REQUEST, returnCode, subReturnCode, severity);

    }


@Builder
    public BusinessException(String title, HttpStatus httpStatus, String returnCode, String subReturnCode, ErrorSeverity severity) {

        super(title);

        this.title = title;

        this.httpStatus = (HttpStatus) Optional.ofNullable(httpStatus).orElse(HttpStatus.BAD_REQUEST);

        this.returnCode = returnCode;

        this.subReturnCode = subReturnCode;

        this.severity = severity;

    }

    public String getTitle() {
        return title;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getSubReturnCode() {
        return subReturnCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorSeverity getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "title='" + title + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", subReturnCode='" + subReturnCode + '\'' +
                ", httpStatus=" + httpStatus +
                ", severity=" + severity +
                '}';
    }
}
