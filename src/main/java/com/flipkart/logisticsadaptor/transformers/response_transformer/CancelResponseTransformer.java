package com.flipkart.logisticsadaptor.transformers.response_transformer;

import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CancelShipmentResponse;
import com.flipkart.logisticsadaptor.models.ekart.ResponseDetails;
import com.flipkart.logisticsadaptor.models.ondc.oncancel.OnCancelMessage;

public class CancelResponseTransformer implements ResponseTransformer<CancelShipmentResponse,OnCancelMessage> {

    @Override
    public OnCancelMessage convertResponse(CancelShipmentResponse responseTransformerInput) {

        for(ResponseDetails responseDetails:responseTransformerInput.getResponseDetails()){
            if(responseDetails.getMessageS().toString()=="REQUEST_RECEIVED"){
                return OnCancelMessage.builder()
                        .build();
            }
            else{
                return  OnCancelMessage.builder()
                        .build();
            }
        }
        return null;

    }

}
