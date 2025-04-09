package com.dotcapital.audit.domain.model;

import com.dotcapital.document.enummer.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;


@Data
@Builder
@AllArgsConstructor
public class Audit {

    private final Long id;
//    private final String documentId;
//    private final DocumentType documentType;
    @Builder.Default
    private final String userId = DcConstant.USER_SYSTEM;
    private final String moduleActivity;
    private final AuditType auditType;
//    private final String actionVariable;
    private final String oldValue;
    private final String newValue;
    private final String logText;
    @Builder.Default
    private final Instant createdDate = Instant.now();
    @Builder.Default
    private final Instant lastModifiedDate = Instant.now();
}
