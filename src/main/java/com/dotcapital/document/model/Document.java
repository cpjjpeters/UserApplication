package com.dotcapital.document.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.model */


@Data
@NoArgsConstructor
public class Document {
    private Long documentId;
    private String documentName;
    private Boolean finalized;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Boolean getFinalized() {
        return finalized;
    }

    public void setFinalized(Boolean finalized) {
        this.finalized = finalized;
    }

    public String getDocumentAuthor() {
        return documentAuthor;
    }

    public void setDocumentAuthor(String documentAuthor) {
        this.documentAuthor = documentAuthor;
    }

    private String documentAuthor;


}
