package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.commons.models.internal.Order;

public interface OrderService {

    public String getTrackingIdForOrder(String orderId);

    public Order persistsOrder(AdaptorRequest adaptorRequest);

}
