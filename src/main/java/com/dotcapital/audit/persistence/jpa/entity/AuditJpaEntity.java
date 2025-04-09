package com.dotcapital.audit.persistence.jpa.entity;

import com.dotcapital.document.enummer.DocumentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;


@Table(name = "AUDIT")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AuditJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

//    @Column(name = "DOCUMENT_ID")
//    private String documentId;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "DOCUMENT_TYPE")
//    private DocumentType documentType;

//    @Size(max = 8)
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "MODULE_ACTIVITY")
    private String moduleActivity;

    // TODO Can we make it a Enumeration?
    @Column(name = "AUDIT_TYPE")
    private String auditType;

//    @Column(name = "ACTION_VARIABLE")
//    private String actionVariable;

    @Column(name = "OLD_VALUE")
    private String oldValue;

    @Column(name = "NEW_VALUE")
    private String newValue;

    @Column(name = "LOG")
    private String logText;

    @CreatedDate
    @Column(name = "CREATED_DATE", updatable = false)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private Instant lastModifiedDate;


	public AuditJpaEntity() {
	}


}
