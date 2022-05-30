package com.flipkart.logisticsadaptor.commons.models;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ekart.CreateShipmentResponse;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.models.ondc.common.Context;
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

    private Context context;

    private Merchant merchant;

    private CreateShipmentResponse createShipmentResponse;

    private String trackingId;

    private String orderStatus;


    public AdaptorRequest(ConfirmRequest confirmRequest){
        requestType = RequestType.CONFIRM;
        context = confirmRequest.getContext();
        order = confirmRequest.getMessage().getOrder();
    }




}
