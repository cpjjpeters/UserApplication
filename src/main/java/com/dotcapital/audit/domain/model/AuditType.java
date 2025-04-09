package com.dotcapital.audit.domain.model;


public enum AuditType {

    BUSINESS_TYPE("business"),
    SYSTEM_TYPE("system");

    private final String value;

    AuditType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
