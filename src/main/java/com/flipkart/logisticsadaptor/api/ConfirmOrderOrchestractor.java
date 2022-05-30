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

import java.nio.file.LinkOption;

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
            OnConfirmMessage onConfirmMessage =  ekartAdaptorEngine.getConfirmMessage(adaptorRequest);
            onConfirmMessage = processMessage(onConfirmMessage, merchant);
            request.setContext(confirmRequest.getContext());
            request.setMessage(onConfirmMessage);
            adaptorRequest.setOrder(onConfirmMessage.getOrder());
            orderService.persistsOrder(adaptorRequest);
        }
        catch (Exception e){
            log.error("Confirm Request" , confirmRequest, e.getMessage());
        }
        return request;
    }

    private OnConfirmMessage processMessage(OnConfirmMessage onConfirmMessage , Merchant merchant){
        Order order = onConfirmMessage.getOrder();
        onConfirmMessage.getOrder().setPayment(paymentDetailsService.getPaymentDetails(order, merchant));
        onConfirmMessage.getOrder().setQuote(quotationService.getQuotationForOrder(order, merchant));
        return onConfirmMessage;
    }
}
