package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchRequest;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.google.inject.Inject;


public class LogisticSearchOrchestrator  {


    private EkartAdaptorEngine ekartAdaptorEngine ;
    @Inject
    public LogisticSearchOrchestrator(EkartAdaptorEngine ekartAdaptorEngine){
        this.ekartAdaptorEngine = ekartAdaptorEngine;
    }



    public OnSearchRequest orchestrate(SearchRequest searchRequest){
        OnSearchRequest onSearchRequest = new OnSearchRequest();
        onSearchRequest.setContext(searchRequest.getContext());
        onSearchRequest.setMessage(getSearchMessage(searchRequest));
        return onSearchRequest;
    }

    private OnSearchMessage getSearchMessage(SearchRequest searchRequest){
        return ekartAdaptorEngine.getSearchResponse(searchRequest);
    }

}
