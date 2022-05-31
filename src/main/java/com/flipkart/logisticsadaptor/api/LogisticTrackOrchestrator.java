package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.engine.EkartAdaptorEngine;
import com.flipkart.logisticsadaptor.models.ondc.ontrack.OnTrackMessage;
import com.flipkart.logisticsadaptor.models.ondc.ontrack.OnTrackRequest;
import com.flipkart.logisticsadaptor.models.ondc.track.TrackRequest;
import com.google.inject.Inject;

public class LogisticTrackOrchestrator {

    @Inject
    private EkartAdaptorEngine ekartAdaptorEngine ;


    public OnTrackRequest orchestrate(TrackRequest trackRequest){
        OnTrackRequest onTrackRequest = new OnTrackRequest();
        onTrackRequest.setContext(trackRequest.getContext());
        onTrackRequest.setMessage(getTrackMessage(trackRequest));
        return onTrackRequest;
    }
    public OnTrackMessage getTrackMessage(TrackRequest trackRequest){
        return ekartAdaptorEngine.getTrackResponse(trackRequest);
    }
}
