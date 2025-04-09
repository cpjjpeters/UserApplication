package com.dotcapital.document.enummer;

/* carlpeters created on 09/04/2025 inside the package - com.dotcapital.document.enummer */
public enum DocumentType {
    CONF ("confirmation"),
    UNKN("unknown");

    public final String label;

    DocumentType(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
