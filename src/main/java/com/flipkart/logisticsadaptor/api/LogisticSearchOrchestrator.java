package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchRequest;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.google.inject.Inject;


public class LogisticSearchOrchestrator  {


    private EkartAdaptorEngine ekartAdaptorEngine ;
    private QuotationService quotationService;
    private MerchantService merchantService;
    @Inject
    public LogisticSearchOrchestrator(EkartAdaptorEngine ekartAdaptorEngine, MerchantService merchantService, QuotationService quotationService){
        this.ekartAdaptorEngine = ekartAdaptorEngine;
        this.merchantService = merchantService;
        this.quotationService = quotationService;
    }



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
