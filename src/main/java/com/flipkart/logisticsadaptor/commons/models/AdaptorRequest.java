package com.flipkart.logisticsadaptor.commons.models;

import com.flipkart.logisticsadaptor.models.ondc.confirm.ConfirmRequest;

public class AdaptorRequest {

    private RequestType requestType;

    private


    public AdaptorRequest(ConfirmRequest confirmRequest){
        requestType = RequestType.CONFIRM;

    }


}
