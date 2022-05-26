package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.commons.models.internal.RateCard;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.common.Price;
import com.flipkart.logisticsadaptor.models.ondc.common.Quotation;
import com.google.inject.Singleton;

@Singleton
public class QuotationServiceImpl implements QuotationService{


    @Override
    public Quotation getQuotationForOrder(Order order, Merchant merchant) {
        try {
            return Quotation.builder()
                    .price(getPrice(order, merchant.getRateCard()))
                    .build();
        }
        catch (Exception e){

        }
        return null;

    }

    private Price getPrice(Order order, RateCard rateCard){
        return Price.builder()
                .value((float) rateCard.getBasePrice())
                .build();
    }
}
