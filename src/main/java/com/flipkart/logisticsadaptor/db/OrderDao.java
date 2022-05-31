package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.commons.models.internal.Order;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


public class OrderDao extends AbstractDAO<Order> {

    @Inject
    public OrderDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Order find(String orderId) {
        return get(orderId);
    }

    public String getTrackingId(String orderId){
        //return find(orderId).getTrackingId();
        return  "TESC123456";
    }

    public Order create(Order order){
        return  persist(order);
    }

}
