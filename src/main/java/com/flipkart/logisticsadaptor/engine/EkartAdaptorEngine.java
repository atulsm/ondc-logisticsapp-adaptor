package com.flipkart.logisticsadaptor.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.commons.clients.BasicHttpClient;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.models.ekart.SLAResponse;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.sun.jersey.api.client.WebResource;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.client.ClientResponse;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

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
