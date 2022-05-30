package com.flipkart.logisticsadaptor.commons.models;

import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ekart.CreateShipmentResponse;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.confirm.ConfirmRequest;
import lombok.*;

/*
* A common platform object serving the use case for different API
* */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdaptorRequest {

    private RequestType requestType;

    private Order order;

    private CheckServiceabilityResponse checkServiceabilityResponse = null;

    private CreateShipmentResponse createShipmentResponse = null;


    public AdaptorRequest(ConfirmRequest confirmRequest){
        requestType = RequestType.CONFIRM;
    }




}
