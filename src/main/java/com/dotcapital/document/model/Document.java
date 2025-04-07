package com.dotcapital.document.model;

import jakarta.persistence.Column;
import lombok.Data;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.model */


@Data
public class Document {
    private Long documentId;
    private String documentName;
    private Boolean finalized;
    private String documentAuthor;
}
