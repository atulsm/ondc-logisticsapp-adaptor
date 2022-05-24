package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.core.Bucket;
import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class MerchantDao extends AbstractDAO<Merchant> {
    @Inject
    public MerchantDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Merchant find(String merchantId) {
        return get(merchantId);
    }
}
