package com.flipkart.logisticsadaptor.engine;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Singleton;

@Getter
@Setter
@Singleton
public class EkartConfig {
    private String eKartHost;
    private int port;
}
