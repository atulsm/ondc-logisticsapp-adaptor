package com.flipkart.logisticsadaptor.commons.models;

import lombok.Getter;

@Getter
public class KeyValue {
    private String key;
    private String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
