package com.flipkart.logisticsadaptor.models.ekart.enums;

public enum AllowedGoodsCategory {
    ANY("Any"),
    ESSENTIALS("Essentials");

    private final String allowedGoodsCategory;

    AllowedGoodsCategory(final String policy) {
        this.allowedGoodsCategory = policy;
    }

    public String getAllowedGoodsCategory() {
        return this.allowedGoodsCategory;
    }
}
