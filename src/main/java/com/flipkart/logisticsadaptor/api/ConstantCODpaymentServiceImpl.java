package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.common.Payment;
import com.flipkart.logisticsadaptor.models.ondc.common.PaymentParams;
import com.google.inject.Singleton;


@Singleton
public class ConstantCODpaymentServiceImpl implements ConstantCODpaymentService {

    @Override
    public Payment getPaymentDetails(){
        try {
            return Payment.builder()
                    .params(paymentParamsForPayment())
                    .status("NOT-PAID")
                    .type("ON-FULFILMENT")
                    .build();
        }
        catch (Exception e){

        }
        return null;
        }
    private PaymentParams paymentParamsForPayment(){

            return PaymentParams.builder()
                    .mode("COD")
                    .build();
    }
}
