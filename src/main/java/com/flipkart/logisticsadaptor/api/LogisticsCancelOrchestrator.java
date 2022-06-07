package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.cancel.CancelRequest;
import com.flipkart.logisticsadaptor.models.ondc.oncancel.OnCancelMessage;
import com.flipkart.logisticsadaptor.models.ondc.oncancel.OnCancelRequest;
import com.google.inject.Inject;

public class LogisticsCancelOrchestrator {
    @Inject
    private EkartAdaptorEngine ekartAdaptorEngine ;

    @Inject
    private OrderService orderService;

    @Inject
    private MerchantService merchantService;


    public OnCancelRequest orchestrate(CancelRequest cancelRequest){

        cancelRequest.getMessage().setTrackingId(orderService.getTrackingIdForOrder(cancelRequest.getMessage().getOrderId()));
        Merchant merchant = merchantService.getMerchantDetails(cancelRequest.getContext());
        cancelRequest.setMerchant(merchant);
        OnCancelRequest onCancelRequest = new OnCancelRequest();
        onCancelRequest.setContext(cancelRequest.getContext());
        onCancelRequest.setMessage(getCancelMessage(cancelRequest));
        return onCancelRequest;
    }
    public OnCancelMessage getCancelMessage(CancelRequest cancelRequest){
        return ekartAdaptorEngine.getCancelResponse(cancelRequest);
    }
}
