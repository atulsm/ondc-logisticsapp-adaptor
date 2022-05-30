package com.flipkart.logisticsadaptor.models.ekart.enums;

import lombok.Getter;

@Getter
public enum FulfilmentType {

    FBF("fbf"),
    NON_FBF("non_fbf");

    private final String name;

    FulfilmentType(String name) {
        this.name = name;
    }

}
