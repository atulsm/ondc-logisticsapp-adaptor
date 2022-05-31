package com.flipkart.logisticsadaptor.guice;

import com.flipkart.logisticsadaptor.LogisticsAdaptorConfiguration;
import com.flipkart.logisticsadaptor.api.*;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.db.MerchantDao;
import com.flipkart.logisticsadaptor.db.RateCardDao;
import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.engine.EkartConfig;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.google.inject.*;
import com.google.inject.Module;
import com.google.inject.name.Named;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

public class ServerModule implements Module {
    HibernateBundle<LogisticsAdaptorConfiguration> hibernate;
    public ServerModule(HibernateBundle<LogisticsAdaptorConfiguration> hibernate){
        this.hibernate = hibernate;
    }
    @Override
    public void configure(Binder binder) {
        binder.bind(OrderService.class).to(OrderServiceImpl.class);
        binder.bind(PaymentDetailsService.class).to(StaticPaymentDetailsService.class);
        binder.bind(MerchantService.class).to(MerchantServiceImpl.class);
        binder.bind(ReverseGeocodeService.class).to(LocalReverseGeocodeService.class);
        binder.bind(QuotationService.class).to(QuotationServiceImpl.class);


    }


    @Provides
    @Singleton
    @Inject
    public EkartConfig provideEkartConfig(LogisticsAdaptorConfiguration logisticsAdaptorConfiguration){
        return logisticsAdaptorConfiguration.getEkartConfig();
    }


    @Inject
    @Provides
    @Singleton
    public SessionFactory provideSessionFactory(){
        return hibernate.getSessionFactory();
    }












}
