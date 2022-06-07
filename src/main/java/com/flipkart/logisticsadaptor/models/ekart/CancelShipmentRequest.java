package com.flipkart.logisticsadaptor.models.ekart;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
@Builder
public class CancelShipmentRequest {

    @Builder.Default
    private String requestId= UUID.randomUUID().toString();;
    private List<RequestDetails> requestDetails;

    @JsonIgnore
    public List<String> getTrackingIds(){
        List<String> trackingIds = new ArrayList<>();
        for(RequestDetails requestDetails: requestDetails){
                trackingIds.add(requestDetails.getTrackingId());
        }
        return trackingIds;
    }

}
