package com.flipkart.logisticsadaptor.resources;


import com.flipkart.logisticsadaptor.api.LogisticsAdaptorService;
import com.flipkart.logisticsadaptor.core.Bucket;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/admin")
public class AdminResource {

    @Path("/enable/mock/{keyword}")
    public String enableMock(@PathParam("keyword") String apiName){
       return null;
    }

    @Path("/disable/mock/{keyword}")
    public String disableMock(@PathParam("keyword") String apiName){
        return null;
    }
}
