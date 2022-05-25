package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import com.flipkart.logisticsadaptor.models.ekart.RateCard;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.common.Payment;
import com.flipkart.logisticsadaptor.models.ondc.common.PaymentParams;
import com.google.inject.Singleton;

@Singleton
public class StaticPaymentDetailsService implements PaymentDetailsService{

    private static final String COD_MODE = "COD";
    private static final String PAYMENT_TYPE = "POST-FULFILLMENT";
    @Override
    public Payment getPaymentDetails(Order order, Merchant merchant) {
        return Payment.builder()
                .params(getPaymentParams(order, merchant.getRateCard()))
                .type(PAYMENT_TYPE)
                .build();

    }

    private PaymentParams getPaymentParams(Order order, RateCard rateCard){
        return PaymentParams.builder()
                .mode(COD_MODE)
                .amount(String.valueOf(rateCard.getBasePrice()))
                .build();
    }
}
