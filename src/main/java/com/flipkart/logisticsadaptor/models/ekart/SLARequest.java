package com.flipkart.logisticsadaptor.models.ekart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SLARequest {
    private String request_id;
    private String dispatch_date;
    private String customer_pincode;
    private String seller_pincode;
    private String rto_pincode;
    private float length;
    private float breadth;
    private float height;
    private float weight;
    private String delivery_type;
    private String service_type;
    private boolean is_dangerous;
    private boolean is_fragile;

}