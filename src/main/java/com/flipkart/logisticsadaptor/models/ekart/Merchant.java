package com.flipkart.logisticsadaptor.models.ekart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Merchant {
    private String merchantId;
    private String merchantCode;
    private String authHeader;
}
