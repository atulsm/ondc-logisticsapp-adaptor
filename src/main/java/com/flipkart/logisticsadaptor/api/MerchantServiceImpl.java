package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.db.MerchantDao;
import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.common.Context;
import com.google.inject.Inject;

public class MerchantServiceImpl implements MerchantService{

    @Inject
    private MerchantDao merchantDao;

    @Override
    public Merchant getMerchantDetails(String bapId) {
        return merchantDao.find(bapId);
    }

    @Override
    public Merchant getMerchantDetails(Context context) {
        String bapId = context.getBapId();
        return getMerchantDetails(bapId);
    }
}
