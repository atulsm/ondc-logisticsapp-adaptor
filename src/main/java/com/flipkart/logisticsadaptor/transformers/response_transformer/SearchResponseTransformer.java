package com.flipkart.logisticsadaptor.transformers.response_transformer;


import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;

public class SearchResponseTransformer  implements ResponseTransformer<CheckServiceabilityResponse, ResponseMessage> {

    @Override
    public ResponseMessage convertResponse(CheckServiceabilityResponse responseTransformerInput) {
        return null;
    }
}
