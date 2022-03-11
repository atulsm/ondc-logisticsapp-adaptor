package com.flipkart.logisticsadaptor.resources;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.logisticsadaptor.api.LogisticsAdaptorService;
import com.flipkart.logisticsadaptor.core.Bucket;

import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/logisticsadaptor")
public class LogisticsAdaptorResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @Path("/{keyword}")
    public String getFromResponseBucket(@PathParam("keyword") String bucketName, String payload){
    	if(payload==null) {
    		System.out.println("Receieved empty payload");
    		return null;
    	}
        Bucket res =  LogisticsAdaptorService.INSTANCE.getBucket(bucketName);
        System.out.println(res);
        return res.getValue();
    }

}
