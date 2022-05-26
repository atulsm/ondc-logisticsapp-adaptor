package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitRequest;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.google.inject.Inject;

public class LogisticInitOrchestrator {

    private EkartAdaptorEngine ekartAdaptorEngine ;
    private QuotationService quotationService;
    private MerchantService merchantService;

    @Inject
    public LogisticInitOrchestrator(EkartAdaptorEngine ekartAdaptorEngine,MerchantService merchantService, QuotationService quotationService){
        this.ekartAdaptorEngine = ekartAdaptorEngine;
        this.merchantService = merchantService;
        this.quotationService = quotationService;
    }



    public OnInitRequest orchestrate(InitRequest initRequest){
        OnInitRequest onInitRequest = new OnInitRequest();
        onInitRequest.setContext(initRequest.getContext());
        onInitRequest.setMessage(getInitMessage(initRequest));
        return onInitRequest;
    }

    private OnInitMessage getInitMessage(InitRequest initRequest){
        return ekartAdaptorEngine.getInitResponse(initRequest);
    }
}
