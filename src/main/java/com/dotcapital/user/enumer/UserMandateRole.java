package com.dotcapital.user.enumer;

import java.util.Arrays;

public enum UserMandateRole {

    BANK_ADMIN("BANK-ADMIN"),
    BANK_DEALER("BANK-DEALER"),
    BANK_DEALER_ADMIN("BANK-DEALER-ADMIN"),
    CUSTOMER_REGULAR("CUSTOMER-REGULAR"),
    CUSTOMER_SUPER_USER("CUSTOMER-SUPER-USER"),
    ;

    private final String value;

    UserMandateRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserMandateRole findByValue(String v) {
        final var type = Arrays.stream(UserMandateRole.values()).filter(a -> a.getValue().equals(v)).findFirst();

        if (type.isEmpty()) {
            throw new IllegalArgumentException(String.format("No OrganisationType found for value %s", v));
        }

        return type.get();
    }
}
