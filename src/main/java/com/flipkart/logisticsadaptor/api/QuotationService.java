package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import com.flipkart.logisticsadaptor.models.ondc.common.Quotation;

public interface QuotationService {
        public Quotation getQuotationForOrder(Order order, Merchant merchant);
}
