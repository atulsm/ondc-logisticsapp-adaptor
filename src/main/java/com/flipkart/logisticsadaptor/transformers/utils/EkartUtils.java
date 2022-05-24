package com.flipkart.logisticsadaptor.transformers.utils;

import com.flipkart.logisticsadaptor.engine.EkartConstants;
import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.common.Descriptor;

import java.util.HashMap;
import java.util.Map;

public class EkartUtils {

    private static final String HEADER_HTTP_X_MERCHANT_CODE = "HTTP_X_MERCHANT_CODE";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    public static Map<String, String> getCommonEkartHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put(HEADER_HTTP_X_MERCHANT_CODE, "JYN");
        headers.put(HEADER_AUTHORIZATION, "B");
        //headers.put(HEADER_CONTENT_TYPE, "application/json");
        return headers;
    }

    public static Descriptor getEkartDescriptor(){
        return Descriptor.builder()
                .name(EkartConstants.EKART_PROVIDER_NAME)
                .build();
    }

    public static Map<String, String>  getHeadersForMerchant(Merchant merchant){
        Map<String, String> headers = new HashMap<>();
        headers.put(HEADER_HTTP_X_MERCHANT_CODE, merchant.getMerchantCode());
        headers.put(HEADER_AUTHORIZATION, merchant.getAuthHeader());
        //headers.put(HEADER_CONTENT_TYPE, "application/json");
        return headers;
    }

}
