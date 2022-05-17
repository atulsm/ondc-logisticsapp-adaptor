package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchRequest;
import com.flipkart.logisticsadaptor.models.ondc.response.Response;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;

import javax.inject.Inject;

import static com.flipkart.logisticsadaptor.utils.EkartUtils.getSLARequestForSearchContext;

public class LogisticSearchOrchestrator {

    @Inject
    EkartAdaptorEngine ekartAdaptorEngine;

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
