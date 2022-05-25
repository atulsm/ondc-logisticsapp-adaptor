package com.flipkart.logisticsadaptor.transformers.utils;

import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;

public class ONDCUtils {

    public static String getBAPId(SearchRequest searchRequest){
        try {
            return searchRequest.getContext().getBapId();
        }catch (Exception e){

        }
        return "NULL";
    }
}
