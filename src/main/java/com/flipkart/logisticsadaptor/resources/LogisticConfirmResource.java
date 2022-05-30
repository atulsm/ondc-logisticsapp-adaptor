package com.flipkart.logisticsadaptor.resources;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.logisticsadaptor.models.ondc.confirm.ConfirmRequest;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmMessage;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmRequest;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchRequest;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/confirm")
public class LogisticConfirmResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @Path("/v1")
    public OnConfirmRequest confirmOrder(ConfirmRequest confirmRequest){
        return OnConfirmRequest.builder()
                .context(confirmRequest.getContext())
                .message(OnConfirmMessage.builder()
                        .order(confirmRequest.getMessage().getOrder())
                        .build())
                .build();
    }

}
