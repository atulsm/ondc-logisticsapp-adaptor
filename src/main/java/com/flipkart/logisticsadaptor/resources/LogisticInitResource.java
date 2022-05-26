package com.flipkart.logisticsadaptor.resources;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.logisticsadaptor.api.LogisticInitOrchestrator;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitRequest;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/init")
public class LogisticInitResource {
    @Inject
    private LogisticInitOrchestrator logisticInitOrchestrator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @Path("/v1")
    public OnInitRequest initV1(InitRequest initRequest){
        return  logisticInitOrchestrator.orchestrate(initRequest);
    }
}
