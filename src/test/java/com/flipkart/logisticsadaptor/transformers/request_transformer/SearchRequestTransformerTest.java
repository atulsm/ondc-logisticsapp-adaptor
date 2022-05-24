package com.flipkart.logisticsadaptor.transformers.request_transformer;

import com.flipkart.logisticsadaptor.api.MerchantService;
import com.flipkart.logisticsadaptor.api.ReverseGeocodeService;
import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.models.ondc.common.*;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import junit.framework.TestCase;
import org.junit.Test;

import javax.inject.Inject;

public class SearchRequestTransformerTest extends TestCase {

    @Inject
    ReverseGeocodeService reverseGeocodeService;
    @Inject
    MerchantService merchantService;
    SearchRequestTransformer searchRequestTransformer = new SearchRequestTransformer(reverseGeocodeService, merchantService);

    @Test
    public void test() throws Exception{
        SearchMessage searchMessage = SearchMessage
                .builder()
                .intent(getIntent())
                .build();
        ClientRequest clientRequest = searchRequestTransformer.getClientRequest(SearchRequest.builder()
                .message(searchMessage)
                .build());
        clientRequest.getHeaders();
    }

    private Intent getIntent(){
        return Intent.builder()
                .fulfillment(Fulfillment.builder()
                        .start(Start.builder()
                                        .location(Location
                                        .builder()
                                        .gps("26.5500,90.4667")
                                        .build())
                                        .build())
                        .end(End.builder()
                                        .location(Location
                                        .builder()
                                        .gps("26.5500,90.4667")
                                        .build())
                                .build())
                        .build())
                .build();

    }

}