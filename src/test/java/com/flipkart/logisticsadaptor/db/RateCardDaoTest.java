package com.flipkart.logisticsadaptor.db;

import com.flipkart.logisticsadaptor.commons.models.internal.RateCard;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RateCardDaoTest extends TestCase {

    RateCardDao rateCardDao;
    MerchantDao merchantDao;
    private Session session;
    @Before
    public void setUp() throws Exception {
        super.setUp();


        SessionFactory sessionFactory = getSessionFactory();
        sessionFactory.openSession();
        session = sessionFactory.openSession();
        rateCardDao = new RateCardDao(sessionFactory);
        merchantDao = new MerchantDao(sessionFactory);
        ManagedSessionContext.bind(session);
    }

    public SessionFactory getSessionFactory(){
        final Configuration config = new Configuration();
        config.setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/logisticsadaptor?enabledTLSProtocols=TLSv1.2");
        config.setProperty(AvailableSettings.USER, "root");
        config.setProperty(AvailableSettings.PASS, "root");
        config.setProperty(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");
        config.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        // Use the same configuration as in the Hibernate bundle to reduce differences between
        // testing and production environments.
        config.setProperty(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "managed");
        config.setProperty(AvailableSettings.USE_GET_GENERATED_KEYS, "true");
        config.setProperty(AvailableSettings.GENERATE_STATISTICS, "true");
        config.setProperty(AvailableSettings.USE_REFLECTION_OPTIMIZER, "true");
        config.setProperty(AvailableSettings.ORDER_UPDATES, "true");
        config.setProperty(AvailableSettings.ORDER_INSERTS, "true");
        config.setProperty(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, "true");
        config.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");

        return config.buildSessionFactory();
    }

    @Test
    public void testSearchById(){
        RateCard rateCard = rateCardDao.find("1");
        rateCard.getRateCardId();
        rateCard.getBasePrice();
    }

    @After
    public void tearDown(){
        session.close();
        ManagedSessionContext.unbind(getSessionFactory());
    }



}