package com.flipkart.logisticsadaptor.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.models.ekart.SLAResponse;
import com.sun.jersey.api.client.WebResource;
import org.glassfish.jersey.client.ClientResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Singleton
public class EkartAdaptorEngine {

    @Inject
    ObjectMapper mapper ;


    public SLAResponse getSLAResponse(SLARequest slaRequest){
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client
                .target("http://localhost:8080/RESTfulExample/rest/json/metallica/get").path("");

        ClientResponse response = webTarget.request().buildPost(SLARequest.class)

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        SLAResponse output =  mapper.readValue(response.getEntity(), SLAResponse.class);
        System.out.println("Output from Server .... \n");
        System.out.println(output);
        return output;


    }



}
