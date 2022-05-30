package com.flipkart.logisticsadaptor.models.ekart.enums;

import java.util.EnumSet;

public enum ShipmentItemAttributes {

    ORDER_ITEM_ID,
    ORDER_ID,
    INVOICE_ID,
    ITEM_DIMENSIONS,
    BRAND_NAME;
    public static EnumSet<ShipmentItemAttributes> requiredShipmentItemAttributes = EnumSet.of(ORDER_ID, INVOICE_ID);

}
