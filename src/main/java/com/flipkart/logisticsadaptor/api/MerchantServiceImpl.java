package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.db.MerchantDao;
import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import com.google.inject.Inject;

public class MerchantServiceImpl implements MerchantService{

    MerchantDao merchantDao;

    @Inject
    MerchantServiceImpl(MerchantDao merchantDao){
        this.merchantDao = merchantDao;
    }

    @Override
    public Merchant getMerchantDetails(String bbpId) {
        return merchantDao.find(bbpId);
    }
}
