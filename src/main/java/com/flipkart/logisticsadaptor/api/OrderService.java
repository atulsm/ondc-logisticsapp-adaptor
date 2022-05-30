package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;

public interface OrderService {

    public String getTrackingIdForOrder(String orderId);

    public void persistsOrder(AdaptorRequest adaptorRequest);

}
