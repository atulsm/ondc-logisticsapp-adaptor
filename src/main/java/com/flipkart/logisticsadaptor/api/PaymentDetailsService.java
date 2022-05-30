package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ekart.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.common.Payment;

public interface PaymentDetailsService {

    public Payment getPaymentDetails(Order order, Merchant merchant);

}
