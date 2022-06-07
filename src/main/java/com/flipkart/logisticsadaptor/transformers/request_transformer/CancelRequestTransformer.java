package com.flipkart.logisticsadaptor.transformers.request_transformer;

import com.flipkart.logisticsadaptor.api.OrderService;
import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.RequestTransformer;
import com.flipkart.logisticsadaptor.models.ekart.CancelShipmentRequest;
import com.flipkart.logisticsadaptor.models.ekart.RequestDetails;
import com.flipkart.logisticsadaptor.models.ondc.cancel.CancelRequest;
import com.flipkart.logisticsadaptor.transformers.utils.EkartUtils;

import java.util.Arrays;
import java.util.List;

public class CancelRequestTransformer implements RequestTransformer<CancelRequest, ClientRequest> {

    private static final String CANCEL_SHIPMENT_URL = "/v2/shipments/rto/create";

    @Override
    public ClientRequest getClientRequest(CancelRequest request) {
        return ClientRequest.builder()
                .headers(EkartUtils.getHeadersForMerchant(request.getMerchant()))
                .url(CANCEL_SHIPMENT_URL)
                .body(getBody(request))
                .build();
    }

    private CancelShipmentRequest getBody(CancelRequest request){
        return CancelShipmentRequest.builder()
                .requestDetails(getRequestDetails(request))
                .build();
}

    public List<RequestDetails> getRequestDetails(CancelRequest request) {
        return Arrays.asList(
                RequestDetails.builder()
                        .trackingId(request.getMessage().getTrackingId())
                        .reason(request.getMessage().getCancellationReasonId())
                        .build()
        );
    }
}
