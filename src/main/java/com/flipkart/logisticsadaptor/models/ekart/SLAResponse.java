package com.flipkart.logisticsadaptor.models.ekart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SLAResponse {
    private String request_id;
    private boolean serviceable;
    private String lane;
    private String allowed_goods_category;
    private String prexo;
    private long prepaid_limit;
    private float cod_limit;
    private boolean rvp;
    private boolean cod;
    private Connections connections;

}
