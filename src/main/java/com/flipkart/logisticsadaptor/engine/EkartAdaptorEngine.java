package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Slf4j
public class EkartAdaptorEngine {



    @Inject
    @Named("EKartSearchClient")
    BaseClient<SearchRequest, ResponseMessage> searchRequestResponseMessageBaseClient;


    public ResponseMessage getSearchResponse(SearchRequest searchRequest){
        try {
            return searchRequestResponseMessageBaseClient.execute(searchRequest);
        }
        catch (Exception e){
            log.error("Exception In getSearchResponse : " + e.getMessage());
        }
       return null;
    }



}
