package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.core.Bucket;
import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class MerchantDao extends AbstractDAO<Merchant> {
    public MerchantDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Merchant find(String merchantId) {
        return get(merchantId);
    }
}
