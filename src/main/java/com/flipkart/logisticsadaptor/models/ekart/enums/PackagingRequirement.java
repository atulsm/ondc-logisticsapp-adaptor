package com.flipkart.logisticsadaptor.models.ekart.enums;

public enum PackagingRequirement {
    ANY("Any"),
    NON_PLASTIC("NonPlastic");

    private final String packagingRequirement;

    PackagingRequirement(final String policy) {
        this.packagingRequirement = policy;
    }

    public String getPackagingRequirement() {
        return this.packagingRequirement;
    }


}
