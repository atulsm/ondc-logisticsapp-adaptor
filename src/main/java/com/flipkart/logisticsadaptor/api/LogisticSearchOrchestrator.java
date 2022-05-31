package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchRequest;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.google.inject.Inject;


public class LogisticSearchOrchestrator  {


    @Inject
    private EkartAdaptorEngine ekartAdaptorEngine ;

    @Inject
    private QuotationService quotationService;

    @Inject
    private MerchantService merchantService;



    public OnSearchRequest orchestrate(SearchRequest searchRequest) throws Exception{
        OnSearchRequest onSearchRequest = new OnSearchRequest();
        onSearchRequest.setContext(searchRequest.getContext());
        onSearchRequest.setMessage(getSearchMessage(searchRequest));
        return onSearchRequest;
    }

    private OnSearchMessage getSearchMessage(SearchRequest searchRequest){
        return ekartAdaptorEngine.getSearchResponse(searchRequest);
    }

}
