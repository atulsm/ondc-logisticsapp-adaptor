package com.flipkart.logisticsadaptor.resources;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.logisticsadaptor.api.LogisticInitOrchestrator;
import com.flipkart.logisticsadaptor.api.LogisticTrackOrchestrator;
import com.flipkart.logisticsadaptor.models.ondc.ontrack.OnTrackRequest;
import com.flipkart.logisticsadaptor.models.ondc.track.TrackRequest;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/track")
public class LogisticsTrackResource {

    @Inject
    private LogisticTrackOrchestrator logisticTrackOrchestrator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @Path("/v1")
    public OnTrackRequest trackv1(TrackRequest trackRequest){
        return logisticTrackOrchestrator.orchestrate(trackRequest);
    }
}
