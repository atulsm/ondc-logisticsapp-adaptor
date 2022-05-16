package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.models.ekart.SLAResponse;
import com.flipkart.logisticsadaptor.models.ondc.response.Response;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;

import javax.inject.Inject;

import static com.flipkart.logisticsadaptor.utils.EkartUtils.getSLARequestForSearchContext;

public class LogisticSearchOrchestrator {

    @Inject
    EkartAdaptorEngine ekartAdaptorEngine;

    public Response orchestrate(SearchRequest searchRequest){
        Response response = new Response();
        response.setContext(searchRequest.getContext());
        response.setMessage(getSearchMessage(searchRequest));
        return response;
    }

    private ResponseMessage getSearchMessage(SearchRequest searchRequest){
        return ekartAdaptorEngine.getSearchResponse(searchRequest);
    }
}
