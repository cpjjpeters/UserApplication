package com.dotcapital.exception;

import lombok.Builder;
import lombok.Data;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.exception */
@Data
@Builder
public class ErrorInput {
    private String title;
    private String returnCode;
    private String subReturnCode;
    private ErrorSeverity severity;

}
