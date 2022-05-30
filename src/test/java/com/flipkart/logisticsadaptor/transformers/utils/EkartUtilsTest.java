package com.flipkart.logisticsadaptor.transformers.utils;

import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class EkartUtilsTest extends TestCase {

    @Test
    public void testGetTrackingIdForMerchant() {
        Merchant merchant = Merchant.builder()
                                    .merchantCode("TES")
                                    .build();
        String trackingId = EkartUtils.getTrackingIdForMerchant(merchant, true);
        Assert.assertTrue(trackingId.length()==14);
    }
}