package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.models.ekart.internal.RateCard;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class RateCardDao extends AbstractDAO<RateCard> {
    @Inject
    public RateCardDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public RateCard find(String rateCarId) {
        return get(rateCarId);
    }
}
