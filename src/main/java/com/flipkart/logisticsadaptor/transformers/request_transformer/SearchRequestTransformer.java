package com.flipkart.logisticsadaptor.transformers.request_transformer;

import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.RequestTransformer;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;

import java.util.List;
import java.util.Map;

public class SearchRequestTransformer  implements RequestTransformer<SearchRequest, ClientRequest> {

    private static final String ITERATOR_URL = "/sherlock/v2/iterator";

    @Override
    public ClientRequest getClientRequest(SearchRequest request) {
        return null;
    }
}
