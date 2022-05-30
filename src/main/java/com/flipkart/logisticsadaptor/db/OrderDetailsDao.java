package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.models.ekart.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ekart.internal.Order;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


public class OrderDetailsDao extends AbstractDAO<Order> {

    @Inject
    public OrderDetailsDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Order find(String orderId) {
        return get(orderId);
    }

    public String getTrackingId(String orderId){
        return find(orderId).getTrackingId();
    }

    public Order create(Order order){
        return  persist(order);
    }

}
