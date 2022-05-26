package com.flipkart.logisticsadaptor.transformers.response_transformer;

import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;

public class InitResponseTransformer implements ResponseTransformer<CheckServiceabilityResponse,OnInitMessage>{



    @Override
    public OnInitMessage convertResponse(CheckServiceabilityResponse responseTransformerInput) {
        return OnInitMessage.builder()
                .order(getOrderForContext(responseTransformerInput))
                .build();
    }

    private Order getOrderForContext(CheckServiceabilityResponse checkServiceabilityResponse){
        if(checkServiceabilityResponse.getCOD()) {
            return Order.builder()
                    .isCOD(true)
                    .build();
        }
        return Order.builder()
                .build();
    }

}
