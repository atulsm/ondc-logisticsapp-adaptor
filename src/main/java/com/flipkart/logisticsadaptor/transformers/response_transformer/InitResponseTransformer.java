package com.flipkart.logisticsadaptor.transformers.response_transformer;

import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.common.Payment;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.transformers.utils.EkartUtils;

import java.util.Arrays;

public class InitResponseTransformer implements ResponseTransformer<CheckServiceabilityResponse,OnInitMessage>{
    @Override
    public OnInitMessage convertResponse(CheckServiceabilityResponse responseTransformerInput,InitRequest request) {
        return OnInitMessage.builder()
                .order(getOrderForContext(responseTransformerInput,request))
                .build();
    }
    private Order getOrderForContext(CheckServiceabilityResponse checkServiceabilityResponse,InitRequest request){
        Order order=request.getMessage().getOrder();
        order.setPayment(paymentForOrder(checkServiceabilityResponse,request));
        return order;
    }
    private paymentForOrder(CheckServiceabilityResponse checkServiceabilityResponse,InitRequest request){
        Payment payment=new Payment();
        if(){
            payment.getParams().setMode("COD");
            payment.setStatus("NOT-PAID");
            payment.setType("ON-FULFILMENT");
        }
    }
}
