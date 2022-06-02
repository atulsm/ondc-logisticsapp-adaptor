package com.flipkart.logisticsadaptor.engine;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Singleton;

@Getter
@Setter
@Singleton
public class EkartConfig {
    private String ekartStageHost;
    private String ekartProdHost;
    private int port;

    public String getEKartHost(){
        return ekartProdHost;
    }

    public String getEkartStageHost(){
        return ekartStageHost;
    }


}
