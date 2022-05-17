package com.flipkart.logisticsadaptor.transformers.utils;

import java.util.HashMap;
import java.util.Map;

public class EkartUtils {

    private static final String HEADER_HTTP_X_MERCHANT_CODE = "HTTP_X_MERCHANT_CODE";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";

    public static Map<String, String> getCommonEkartHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put(HEADER_HTTP_X_MERCHANT_CODE, "JYN");
        headers.put(HEADER_AUTHORIZATION, "test");
        //headers.put(HEADER_CONTENT_TYPE, "application/json");
        return headers;
    }
}
