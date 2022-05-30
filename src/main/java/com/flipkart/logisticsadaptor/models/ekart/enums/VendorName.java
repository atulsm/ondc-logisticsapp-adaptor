package com.flipkart.logisticsadaptor.models.ekart.enums;

/**
 * Created by vaibhav.janardhan on 20/10/16.
 */
public enum VendorName {

    EKART("flipkartlogistics"),
    DEFAULT("flipkartlogistics");
    private final String value;

    VendorName(final String value) {
        this.value = value;
    }

    public String getVendorName() {
        return value;
    }
}
