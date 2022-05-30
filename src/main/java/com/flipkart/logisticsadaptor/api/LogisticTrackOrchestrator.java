package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.ontrack.OnTrackRequest;
import com.flipkart.logisticsadaptor.models.ondc.track.TrackRequest;

public class LogisticTrackOrchestrator {

    private EkartAdaptorEngine ekartAdaptorEngine ;

    public LogisticTrackOrchestrator(EkartAdaptorEngine ekartAdaptorEngine){
        this.ekartAdaptorEngine=ekartAdaptorEngine;
    }
    public OnTrackRequest orchestrate(TrackRequest trackRequest){
        OnTrackRequest onTrackRequest = new OnTrackRequest();
        onTrackRequest.setContext(trackRequest.getContext());
        onTrackRequest.setMessage(getTrackMessage(trackRequest));
        return onTrackRequest;
    }
    public OnInitMessage getTrackMessage(TrackRequest trackRequest){
        return ekartAdaptorEngine.getTrackResponse(trackRequest);
    }
}
