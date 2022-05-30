package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;

public interface MerchantService {

    public Merchant getMerchantDetails(String bbpId);
}
