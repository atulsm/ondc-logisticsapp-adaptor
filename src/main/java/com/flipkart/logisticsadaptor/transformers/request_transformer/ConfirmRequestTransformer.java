package com.flipkart.logisticsadaptor.transformers.request_transformer;

import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.RequestTransformer;
import com.flipkart.logisticsadaptor.models.ekart.*;
import com.flipkart.logisticsadaptor.models.ondc.confirm.ConfirmRequest;
import com.flipkart.logisticsadaptor.transformers.utils.EkartUtils;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static com.flipkart.logisticsadaptor.transformers.utils.EkartUtils.*;

public class ConfirmRequestTransformer implements RequestTransformer<AdaptorRequest , ClientRequest> {

    private static final String CREATE_SHIPMENT_URL = "/v2/shipments/create";
    @Override
    public ClientRequest getClientRequest(AdaptorRequest request) {
        return ClientRequest.builder()
                .headers(EkartUtils.getHeadersForMerchant(request.getMerchant()))
                .url(CREATE_SHIPMENT_URL)
                .body(getBody(request))
                .build();
    }

    private CreateShipmentRequest getBody(AdaptorRequest adaptorRequest){
        return CreateShipmentRequest.builder()
                .clientName(adaptorRequest.getMerchant().getMerchantCode())
                .services(getServices(adaptorRequest))
                .build();
    }

    public List<Service> getServices(AdaptorRequest adaptorRequest){
        ServiceDetail serviceDetail = ServiceDetail.builder()
                .serviceData(getServiceData(adaptorRequest))
                .shipment(getShipmentDetails(adaptorRequest))
                .build();

        return Arrays.asList(
                Service.builder()
                        .serviceDetails(Arrays.asList(serviceDetail))
                        .build()
        );
    }

    public ServiceData getServiceData(AdaptorRequest adaptorRequest){
        return ServiceData.builder()
                .amountToCollect(getAmountInRupees(adaptorRequest.getOrder()))
                .source(getLocationForAddress(getStartAddress(adaptorRequest.getOrder())))
                .destination(getLocationForAddress(getEndAddress(adaptorRequest.getOrder())))
                .build();
    }

    public ShipmentDetails getShipmentDetails(AdaptorRequest adaptorRequest){
            return ShipmentDetails.builder()
                    .trackingId(getTrackingIdForMerchant(adaptorRequest.getMerchant(), true))
                    .shipmentValue(getAmountInRupees(adaptorRequest.getOrder()))
                    .shipmentDimensions(getShipmentDimensions(adaptorRequest.getOrder()))
                    .shipmentItems(getShipmentItems(adaptorRequest.getOrder()))
                    .build();
    }



}
