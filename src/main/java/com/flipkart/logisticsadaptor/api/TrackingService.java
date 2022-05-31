package com.flipkart.logisticsadaptor.api;


import com.flipkart.logisticsadaptor.models.ondc.common.Tracking;

public interface TrackingService {
    public Tracking getTrackingURL(String orderid);

}
