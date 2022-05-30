package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.confirm.ConfirmRequest;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmMessage;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmRequest;
import com.google.inject.Inject;

public class ConfirmOrderOrchestractor {

    @Inject
    private EkartAdaptorEngine ekartAdaptorEngine;

    @Inject
    private OrderService orderService;

    @Inject
    private MerchantService merchantService;

    @Inject
    private QuotationService quotationService;


    public OnConfirmRequest orchestrate(ConfirmRequest confirmRequest){
        AdaptorRequest adaptorRequest = new AdaptorRequest(confirmRequest);
      return null;
    }
}
