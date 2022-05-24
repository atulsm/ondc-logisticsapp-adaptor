package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitRequest;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.google.inject.Inject;

public class LogisticInitOrchestrator {

    private EkartAdaptorEngine ekartAdaptorEngine ;
    @Inject
    public LogisticInitOrchestrator(EkartAdaptorEngine ekartAdaptorEngine){
        this.ekartAdaptorEngine = ekartAdaptorEngine;
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
