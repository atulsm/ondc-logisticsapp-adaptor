package com.flipkart.logisticsadaptor.guice;

import com.flipkart.logisticsadaptor.LogisticsAdaptorConfiguration;
import com.flipkart.logisticsadaptor.api.LocalReverseGeocodeService;
import com.flipkart.logisticsadaptor.api.LogisticSearchOrchestrator;
import com.flipkart.logisticsadaptor.api.ReverseGeocodeService;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.engine.EkartConfig;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.google.inject.*;
import com.google.inject.Module;
import com.google.inject.name.Named;

public class ServerModule implements Module {
    @Override
    public void configure(Binder binder) {



    }

    @Provides
    @Singleton
    @Inject
    public LogisticSearchOrchestrator provideLogisticSearchOrchestrator(EkartAdaptorEngine ekartAdaptorEngine){
            return new LogisticSearchOrchestrator(ekartAdaptorEngine) ;
    }

    @Provides
    @Singleton
    @Inject
    public EkartAdaptorEngine provideEkartAdaptorEngine(@Named("EKartSearchClient") BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient){
        return new EkartAdaptorEngine( searchRequestResponseMessageBaseClient) ;
    }

    @Provides
    @Singleton
    public ReverseGeocodeService provideLocalReverseGeocodeService(){
        return new LocalReverseGeocodeService() ;
    }

    @Provides
    @Singleton
    @Inject
    private EkartConfig provideEkartConfig(LogisticsAdaptorConfiguration logisticsAdaptorConfiguration){
        return logisticsAdaptorConfiguration.getEkartConfig();
    }






}
