package com.dotcapital.audit.domain.model;


import com.dotcapital.document.enummer.DocumentType;

import java.time.Instant;

public final class QueueAuditBuilder {

    private final String moduleActivity = ModuleActivity.OTHER_ERROR.toString();

    private String documentId;
    private DocumentType documentType;
    private String auditType;
    private String logText;

    QueueAuditBuilder() {
    }

    public static QueueAuditBuilder builder() {
        return new QueueAuditBuilder();
    }

    public QueueAuditBuilder documentId(String documentId) {
        this.documentId = documentId;
        return this;
    }

    public QueueAuditBuilder documentType(DocumentType documentType) {
        this.documentType = documentType;
        return this;
    }

    public QueueAuditBuilder auditType(String auditType) {
        this.auditType = auditType;
        return this;
    }

    public QueueAuditBuilder logText(String logText) {
        this.logText = logText;
        return this;
    }

//    public Audit build() {
//        return new Audit(null, this.documentId, this.documentType, FisrConstant.USER_SYSTEM, this.moduleActivity, this.auditType, null, null, null, this.logText, Instant.now(), Instant.now());
//    }

    @Override
    public String toString() {
        return "QueueAuditBuilder{" +
            "moduleActivity='" + moduleActivity + '\'' +
            ", documentId='" + documentId + '\'' +
            ", documentType=" + documentType +
            ", auditType='" + auditType + '\'' +
            ", logText='" + logText + '\'' +
            '}';
    }
}
