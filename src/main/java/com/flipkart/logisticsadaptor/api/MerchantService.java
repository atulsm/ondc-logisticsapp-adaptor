package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.common.Context;

public interface MerchantService {

    public Merchant getMerchantDetails(String bapId);

    public Merchant getMerchantDetails(Context context);
}
