package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.confirm.ConfirmRequest;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmMessage;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmRequest;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfirmOrderOrchestractor {

    @Inject
    private EkartAdaptorEngine ekartAdaptorEngine;

    @Inject
    private OrderService orderService;

    @Inject
    private MerchantService merchantService;

    @Inject
    private QuotationService quotationService;

    @Inject
    private PaymentDetailsService paymentDetailsService;


    public OnConfirmRequest orchestrate(ConfirmRequest confirmRequest){
        OnConfirmRequest request = new OnConfirmRequest();
        try {
            AdaptorRequest adaptorRequest = new AdaptorRequest(confirmRequest);
            Merchant merchant = merchantService.getMerchantDetails(confirmRequest.getContext());
            adaptorRequest.setMerchant(merchant);
            adaptorRequest.setOrder(processOrder(adaptorRequest));
            adaptorRequest = ekartAdaptorEngine.processOrder(adaptorRequest);
            request.setContext(confirmRequest.getContext());
            request.setMessage(getOnConfirmMessage(adaptorRequest));
            orderService.persistsOrder(adaptorRequest);
        }
        catch (Exception e){
            log.error("Confirm Request" , confirmRequest, e.getMessage());
        }
        return request;
    }

    private Order processOrder(AdaptorRequest adaptorRequest){
        Order order = adaptorRequest.getOrder();
        order.setState(adaptorRequest.getOrderStatus());
        Merchant merchant = adaptorRequest.getMerchant();
        order.setPayment(paymentDetailsService.getPaymentDetails(order, merchant));
        order.setQuote(quotationService.getQuotationForOrder(order, merchant));
        return order;
    }

    private OnConfirmMessage getOnConfirmMessage(AdaptorRequest adaptorRequest){
        OnConfirmMessage onConfirmMessage = new OnConfirmMessage(adaptorRequest.getOrder());
        return onConfirmMessage;
    }

}
