package com.dotcapital.document.entities;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.entities */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

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
    @Version
    private Long version;

}
