package com.flipkart.logisticsadaptor.models.ekart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDetails {

    private String name;
    private String brandName;
    private String companyName;
    private String panNumber;
    private Date startDateForBilling;
    private String trackingIdPrefixCode;
    private String code;
    private Boolean enabled;
    private Date createdAt;
    private Date updatedAt;
    private String userServiceDomain;
}
