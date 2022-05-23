package com.flipkart.logisticsadaptor.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Geocode {
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    private String latitude;
    private String longitude;
}
