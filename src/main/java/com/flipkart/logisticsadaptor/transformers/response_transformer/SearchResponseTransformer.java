package com.flipkart.logisticsadaptor.transformers.response_transformer;

import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.models.ekart.SLAResponse;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;

public class SearchResponseTransformer  implements ResponseTransformer<SLAResponse, ResponseMessage> {

    @Override
    public ResponseMessage convertResponse(SLAResponse responseTransformerInput) {
        return null;
    }
}
