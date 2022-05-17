package com.flipkart.logisticsadaptor.resources;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.logisticsadaptor.api.LogisticSearchOrchestrator;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchRequest;
import com.flipkart.logisticsadaptor.models.ondc.response.Response;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/search")
public class LogisticSearchResource {

    @Inject
    private LogisticSearchOrchestrator logisticSearchOrchestrator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @Path("/v1")
    public OnSearchRequest searchV1(SearchRequest searchRequest){
        return logisticSearchOrchestrator.orchestrate(searchRequest);
    }
}
