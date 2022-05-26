package com.flipkart.logisticsadaptor.transformers.request_transformer;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.RequestTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CreateShipmentRequest;

public class ConfirmRequestTransformer implements RequestTransformer<AdaptorRequest , ClientRequest> {
    @Override
    public ClientRequest getClientRequest(AdaptorRequest request) {
        return null;
    }
}
