package com.flipkart.logisticsadaptor.models.ekart.enums;

import lombok.Getter;

@Getter
public enum LogisticsType {

    E2E_EKL("e2e_ekl"),
    EKL_3PL("ekl_3pl");

    final private String name;

    LogisticsType(String name) {
        this.name = name;
    }
}
