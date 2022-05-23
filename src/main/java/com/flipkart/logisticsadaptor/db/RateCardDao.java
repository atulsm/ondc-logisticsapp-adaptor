package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import com.flipkart.logisticsadaptor.models.ekart.RateCard;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class RateCardDao extends AbstractDAO<RateCard> {
    public RateCardDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public RateCard find(String rateCarId) {
        return get(rateCarId);
    }
}
