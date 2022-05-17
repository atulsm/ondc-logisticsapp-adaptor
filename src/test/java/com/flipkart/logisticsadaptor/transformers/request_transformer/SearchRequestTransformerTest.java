package com.flipkart.logisticsadaptor.transformers.request_transformer;

import com.flipkart.logisticsadaptor.models.ondc.common.*;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import junit.framework.TestCase;
import org.junit.Test;

import javax.inject.Inject;

public class SearchRequestTransformerTest extends TestCase {

    SearchRequestTransformer searchRequestTransformer = new SearchRequestTransformer();

    @Test
    public void test(){
        SearchMessage searchMessage = SearchMessage
                .builder()
                .intent(getIntent())
                .build();
        searchRequestTransformer.getClientRequest(SearchRequest.builder()
                .message(searchMessage)
                .build());
    }

    private Intent getIntent(){
        return Intent.builder()
                .fulfillment(Fulfillment.builder()
                        .start(Start.builder()
                                        .location(Location
                                        .builder()
                                        .gps("123")
                                        .build())
                                        .build())
                        .end(End.builder()
                                        .location(Location
                                        .builder()
                                        .gps("123")
                                        .build())
                                .build())
                        .build())
                .build();

    }

}