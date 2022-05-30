package com.flipkart.logisticsadaptor.transformers.response_transformer;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CreateShipmentResponse;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmMessage;

public class ConfirmResponseTransformer implements ResponseTransformer<CreateShipmentResponse , CreateShipmentResponse> {
    @Override
    public CreateShipmentResponse convertResponse(CreateShipmentResponse responseTransformerInput) {
        return responseTransformerInput;
    }
}
