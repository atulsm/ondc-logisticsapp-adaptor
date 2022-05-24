package com.flipkart.logisticsadaptor.guice;

import com.flipkart.logisticsadaptor.LogisticsAdaptorConfiguration;
import com.flipkart.logisticsadaptor.api.*;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.db.MerchantDao;
import com.flipkart.logisticsadaptor.db.RateCardDao;
import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.engine.EkartConfig;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
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



    }

    @Provides
    @Singleton
    @Inject
    public LogisticSearchOrchestrator provideLogisticSearchOrchestrator(EkartAdaptorEngine ekartAdaptorEngine , QuotationService quotationService , MerchantService merchantService){
            return new LogisticSearchOrchestrator(ekartAdaptorEngine, merchantService, quotationService) ;
    }

    @Provides
    @Singleton
    @Inject
    public LogisticInitOrchestrator provideLogisticInitOrchestrator(EkartAdaptorEngine ekartAdaptorEngine){
        return new LogisticInitOrchestrator(ekartAdaptorEngine) ;
    }

    @Provides
    @Singleton
    @Inject
    @Named("EKartSearchClient")
    public EkartAdaptorEngine provideEkartAdaptorEngineSearch( @Named("EKartSearchClient") BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient){
        EkartAdaptorEngine obj=new EkartAdaptorEngine();
        obj.EkartAdaptorEngineSearch(searchRequestResponseMessageBaseClient);
        return obj;
    }

    @Provides
    @Singleton
    @Inject
    @Named("EKartInitClient")
    public EkartAdaptorEngine provideEkartAdaptorEngineInit(@Named("EKartInitClient")BaseClient<InitRequest, OnInitMessage> initRequestOnInitMessageBaseClient){
        EkartAdaptorEngine obj=new EkartAdaptorEngine();
        obj.EkartAdaptorEngineInit(initRequestOnInitMessageBaseClient);
        return obj ;
    }

    @Provides
    @Singleton
    public ReverseGeocodeService provideLocalReverseGeocodeService(){
        return new LocalReverseGeocodeService() ;
    }

    @Provides
    @Singleton
    @Inject
    public EkartConfig provideEkartConfig(LogisticsAdaptorConfiguration logisticsAdaptorConfiguration){
        return logisticsAdaptorConfiguration.getEkartConfig();
    }


    @Provides
    @Singleton
    public MerchantService provideMerchantService(MerchantDao merchantDao){
        return new MerchantServiceImpl(merchantDao);
    }

    @Provides
    @Singleton
    public QuotationService provideQuotationService(){
        return new QuotationServiceImpl();
    }

    @Inject
    @Provides
    @Singleton
    public MerchantDao provideMerchantDao(SessionFactory sessionFactory){
        return new MerchantDao(sessionFactory);
    }

    @Inject
    @Provides
    @Singleton
    public RateCardDao provideRateCardDao(SessionFactory sessionFactory){
        return new RateCardDao(sessionFactory);
    }

    @Inject
    @Provides
    @Singleton
    public SessionFactory provideSessionFactory(){
        return hibernate.getSessionFactory();
    }


    @Provides
    @Singleton
    public PaymentDetailsService providePaymentDetailsService(){
        return new StaticPaymentDetailsService();
    }











}
