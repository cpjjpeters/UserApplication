package com.dotcapital.document.entities;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.entities */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name = "DOCUMENTS")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class DocumentJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long documentId;
    @Column(unique = true)
    private String documentName;
    @Column
    private Boolean finalized;
    @Column
    private String documentAuthor;

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
}
