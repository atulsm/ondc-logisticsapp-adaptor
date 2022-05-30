package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.ekart.internal.Merchant;

public interface MerchantService {

    public Merchant getMerchantDetails(String bbpId);
}
