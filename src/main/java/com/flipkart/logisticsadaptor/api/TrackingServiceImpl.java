package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ondc.common.Tracking;

public class TrackingServiceImpl implements TrackingService {
    private static final String URL = "https://ekartlogistics.com/shipmenttrack/";

    @Override
    public Tracking getTrackingURL(String orderid) {
        return Tracking.builder()
                .url(new StringBuilder().append(URL).append(orderid).toString())
                .status("ACTIVE")
                .build();
    }
}
