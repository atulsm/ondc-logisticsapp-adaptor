package com.flipkart.logisticsadaptor.transformers.response_transformer;

import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.common.Payment;
import com.flipkart.logisticsadaptor.models.ondc.common.PaymentParams;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;

import java.util.Arrays;

public class InitResponseTransformer implements ResponseTransformer<CheckServiceabilityResponse,OnInitMessage>{
    @Override
    public OnInitMessage convertResponse(CheckServiceabilityResponse responseTransformerInput) {
        return OnInitMessage.builder()
                .order(getOrderForContext(responseTransformerInput))
                .build();
    }

    private Order getOrderForContext(CheckServiceabilityResponse checkServiceabilityResponse){
        return Order.builder()
                .payment(paymentForOrder(checkServiceabilityResponse))
                .build();
    }
    private Payment paymentForOrder(CheckServiceabilityResponse checkServiceabilityResponse){
        return Payment.builder()
                .params(paymentParamsForPayment(checkServiceabilityResponse))
                .status("NOT-PAID")
                .type("ON-FULFILMENT")
                .build();
    }
    private PaymentParams paymentParamsForPayment(CheckServiceabilityResponse checkServiceabilityResponse){
        if(checkServiceabilityResponse.getCOD()) {
            return PaymentParams.builder()
                   .mode("COD")
                   .build();
        }
        else{
            return PaymentParams.builder()
                    .build();
        }
    }
}
