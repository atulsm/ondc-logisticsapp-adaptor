package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ondc.common.Order;

public class OrderDetailsImpl implements OrderDetails{

    public Order getOrderFromOrderId(String orderId){
        return Order.builder()
                .build();
    }
}
