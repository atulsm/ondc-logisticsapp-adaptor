package com.flipkart.logisticsadaptor.resources;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.logisticsadaptor.api.LogisticSearchOrchestrator;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchRequest;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/search")
public class LogisticSearchResource {

    @Inject
    private LogisticSearchOrchestrator logisticSearchOrchestrator ;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @Path("/v1")
    public OnSearchRequest searchV1(SearchRequest searchRequest) throws Exception{
        return logisticSearchOrchestrator.orchestrate(searchRequest);
    }
}
