package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ondc.response.Response;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;

public class LogisticSearchOrchestrator {

    public Response orchestrate(SearchRequest searchRequest){
        Response response = new Response();
        response.setContext(searchRequest.getContext());
        response.setMessage(getSearchMessage(searchRequest));
        return response;
    }

    private ResponseMessage getSearchMessage(SearchRequest searchRequest){
        return null;
    }
}
