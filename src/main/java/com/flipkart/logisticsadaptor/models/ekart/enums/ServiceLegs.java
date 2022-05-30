package com.flipkart.logisticsadaptor.models.ekart.enums;

public enum ServiceLegs {
    FORWARD("outgoing"),
    REVERSE("incoming");
    private final String value;
    ServiceLegs(final String value) {
        this.value = value;
    }

}
