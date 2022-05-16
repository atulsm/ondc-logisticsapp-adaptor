package com.flipkart.logisticsadaptor.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Geocode {
    private String latitude;
    private String longitude;
}
