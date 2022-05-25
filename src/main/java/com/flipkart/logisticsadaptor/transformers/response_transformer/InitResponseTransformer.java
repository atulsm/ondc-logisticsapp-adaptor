package com.flipkart.logisticsadaptor.transformers.response_transformer;

import com.flipkart.logisticsadaptor.api.ConstantCODpaymentService;
import com.flipkart.logisticsadaptor.api.ConstantCODpaymentServiceImpl;
import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.common.Payment;
import com.flipkart.logisticsadaptor.models.ondc.common.PaymentParams;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.google.inject.Inject;

import java.util.Arrays;

public class InitResponseTransformer implements ResponseTransformer<CheckServiceabilityResponse,OnInitMessage>{


    private ConstantCODpaymentService constantCODpaymentService=new ConstantCODpaymentServiceImpl();

    @Override
    public OnInitMessage convertResponse(CheckServiceabilityResponse responseTransformerInput) {
        return OnInitMessage.builder()
                .order(getOrderForContext(responseTransformerInput))
                .build();
    }

    private Order getOrderForContext(CheckServiceabilityResponse checkServiceabilityResponse){
        if(checkServiceabilityResponse.getCOD()) {
            return Order.builder()
                    .payment(constantCODpaymentService.getPaymentDetails())
                    .build();
        }
        return Order.builder()
                .build();
    }

}
