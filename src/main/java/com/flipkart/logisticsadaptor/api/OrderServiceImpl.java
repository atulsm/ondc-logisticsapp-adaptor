package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.db.OrderDetailsDao;
import com.google.inject.Inject;

public class OrderServiceImpl implements OrderService {

    @Inject
    OrderDetailsDao orderDetailsDao;

    @Override
    public String getTrackingIdForOrder(String orderId) {
        return orderDetailsDao.getTrackingId(orderId);
    }

}
