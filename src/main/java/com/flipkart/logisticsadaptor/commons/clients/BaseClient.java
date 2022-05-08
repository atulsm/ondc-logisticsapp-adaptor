package com.flipkart.logisticsadaptor.commons.clients;

public interface BaseClient<R, F> {
    public abstract F execute(R request) throws Exception;
}
