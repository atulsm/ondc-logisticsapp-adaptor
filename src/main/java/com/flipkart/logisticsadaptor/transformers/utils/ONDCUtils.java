package com.flipkart.logisticsadaptor.transformers.utils;

import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;

public class ONDCUtils {

    public static String getBPPId(SearchRequest searchRequest){
        try {
            return searchRequest.getContext().getBppId();
        }catch (Exception e){

        }
        return "NULL";
    }
}
