package com.flipkart.logisticsadaptor.transformers.request_transformer;

import com.flipkart.logisticsadaptor.api.MerchantService;
import com.flipkart.logisticsadaptor.api.ReverseGeocodeService;
import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.RequestTransformer;
import com.flipkart.logisticsadaptor.engine.EkartConstants;
import com.flipkart.logisticsadaptor.commons.models.internal.Geocode;
import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.models.ondc.common.Fulfillment;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.flipkart.logisticsadaptor.transformers.utils.EkartUtils;
import com.flipkart.logisticsadaptor.transformers.utils.ONDCUtils;

import javax.inject.Inject;

public class SearchRequestTransformer  implements RequestTransformer<SearchRequest, ClientRequest> {


    private ReverseGeocodeService reverseGeocodeService;
    private MerchantService merchantService;
    @Inject
    public SearchRequestTransformer(ReverseGeocodeService reverseGeocodeService, MerchantService merchantService){
        this.reverseGeocodeService = reverseGeocodeService;
        this.merchantService = merchantService;
    }

    private static final String SERVICEABILITY_URL = "/v1/offerings";



    @Override
    public ClientRequest getClientRequest(SearchRequest request){
        Fulfillment fulfillment = request.getMessage().getIntent().getFulfillment();
        Merchant merchant = merchantService.getMerchantDetails(ONDCUtils.getBAPId(request));
        return ClientRequest.builder()
                .headers(EkartUtils.getHeadersForMerchant(merchant))
                .url(SERVICEABILITY_URL)
                .body(getSLABody(fulfillment))
                .build();
    }

    private SLARequest getSLABody(Fulfillment fulfillment){
        return SLARequest.builder()
                .customer_pincode(getPincode(fulfillment.getEnd().getLocation().getGps()))
                .seller_pincode(getPincode(fulfillment.getStart().getLocation().getGps()))
                .serviceType(EkartConstants.FORWARD)
                .build();
    }

    private String getPincode(String gps){
        String parts[] = gps.split(",");
        return reverseGeocodeService.getPincodeFromLatLong(Geocode.builder()
                        .latitude(parts[0])
                        .longitude(parts[1])
                        .build())
                        .toString();
    }



}
