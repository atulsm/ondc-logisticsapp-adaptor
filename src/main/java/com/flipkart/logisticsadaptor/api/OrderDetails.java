package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ondc.common.Order;

public interface OrderDetails {
    public Order getOrderFromOrderId(String orderId);
}
