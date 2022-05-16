package com.flipkart.logisticsadaptor.transformers.utils;

import java.util.HashMap;
import java.util.Map;

public class EkartUtils {

    private static final String HEADER_HTTP_X_MERCHANT_CODE = "HTTP_X_MERCHANT_CODE";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    public static Map<String, String> getCommonEkartHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put(HEADER_HTTP_X_MERCHANT_CODE, "JYN");
        headers.put(HEADER_AUTHORIZATION, "Basic bXludHJhamFib25nOmR1bW15S2V5");
        return headers;
    }
}
