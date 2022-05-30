package com.flipkart.logisticsadaptor.transformers.utils;

import com.flipkart.logisticsadaptor.engine.EkartConstants;
import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.common.Descriptor;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public static String getTrackingIdForMerchant(Merchant merchant , boolean isCod){
        String merchantCode = merchant.getMerchantCode();
        String payment = "C";
        if(!isCod)payment = "P";
        return merchantCode + payment + getUniqueId();
    }

    private static String getUniqueId(){
        LocalDate date =java.time.LocalDateTime.now().toLocalDate();
        String day = addPrefix(date.getDayOfMonth(), 2);
        String month = addPrefix(date.getMonth().getValue(), 2);
        LocalTime currentTime = java.time.LocalDateTime.now().toLocalTime();
        String time = addPrefix(currentTime.getHour(), 2) + addPrefix(currentTime.getMinute(), 2) + addPrefix(currentTime.getSecond(), 2);
        return  day + month + time;
    }

    private static String addPrefix(int num , int k){
        String inp = Integer.toString(num);
        int len = inp.length();
        while(len < k){
            len++;
            inp = "0" + inp;
        }
        return inp;
    }

}
