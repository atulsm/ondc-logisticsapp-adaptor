package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
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
