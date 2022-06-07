package com.flipkart.logisticsadaptor.resources;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.logisticsadaptor.api.LogisticInitOrchestrator;
import com.flipkart.logisticsadaptor.api.LogisticTrackOrchestrator;
import com.flipkart.logisticsadaptor.api.LogisticsCancelOrchestrator;
import com.flipkart.logisticsadaptor.models.ondc.cancel.CancelRequest;
import com.flipkart.logisticsadaptor.models.ondc.oncancel.OnCancelRequest;
import com.flipkart.logisticsadaptor.models.ondc.ontrack.OnTrackRequest;
import com.flipkart.logisticsadaptor.models.ondc.track.TrackRequest;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cancel")
public class LogisticsCancelResource {

    @Inject
    private LogisticsCancelOrchestrator logisticCancelOrchestrator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @Path("/v1")
    public OnCancelRequest cancelv1(CancelRequest cancelRequest){
        return logisticCancelOrchestrator.orchestrate(cancelRequest);
    }
}
