package com.dotcapital.user.enumer;

import java.util.Arrays;

public enum OrganisationType {

    BANK("BANK"), // linked to UserBankBankJourneyData
    MORAL_CUSTOMER("MORAL-CUSTOMER"); // linked to UserMoralcustomerMoralCustomerJourneyData

    private final String value;

    OrganisationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrganisationType findByValue(String v) {
        final var type = Arrays.stream(OrganisationType.values()).filter(a -> a.getValue().equals(v)).findFirst();

        if (type.isEmpty()) {
            throw new IllegalArgumentException(String.format("No OrganisationType found for value %s", v));
        }

        return type.get();
    }
}
