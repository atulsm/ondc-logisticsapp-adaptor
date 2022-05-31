package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.commons.models.internal.Order;
import com.flipkart.logisticsadaptor.db.OrderDao;
import com.google.inject.Inject;

public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDao orderDetailsDao;

    @Override
    public String getTrackingIdForOrder(String orderId) {
        return orderDetailsDao.getTrackingId(orderId);
    }


    @Override
    public Order persistsOrder(AdaptorRequest adaptorRequest){
        Order order = Order.builder()
                .orderId(adaptorRequest.getOrder().getId())
                .trackingId(adaptorRequest.getTrackingId())
                .merchantCode(adaptorRequest.getMerchant().getMerchantCode())
                .orderStatus(adaptorRequest.getOrderStatus())
                .build();
        return orderDetailsDao.create(order);

    }

}
