package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import lombok.extern.slf4j.Slf4j;


@Singleton
@Slf4j
public class EkartAdaptorEngine {



    private BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient;
    @Inject
    public EkartAdaptorEngine(@Named("EKartSearchClient") BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient){
        this.searchRequestResponseMessageBaseClient = searchRequestResponseMessageBaseClient;
    }


    public OnSearchMessage getSearchResponse(SearchRequest searchRequest){
        try {
            return searchRequestResponseMessageBaseClient.execute(searchRequest);
        }
        catch (Exception e){
            log.error("Exception In getSearchResponse : " + e.getMessage());
        }
       return null;
    }

    private BaseClient<InitRequest, OnInitMessage> initRequestResponseMessageBaseClient;
    @Inject
    public EkartAdaptorEngine(@Named("EKartInitClient") BaseClient<InitRequest, OnInitMessage> initRequestResponseMessageBaseClient){
        this.initRequestResponseMessageBaseClient = initRequestResponseMessageBaseClient;
    }


    public OnInitMessage getInitResponse(InitRequest initRequest){
        try {
            return initRequestResponseMessageBaseClient.execute(initRequest);
        }
        catch (Exception e){
            log.error("Exception In getInitResponse : " + e.getMessage());
        }
        return null;
    }

}
