package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ekart.Merchant;

public interface MerchantService {

    public Merchant getMerchantDetails(String bbpId);
}
