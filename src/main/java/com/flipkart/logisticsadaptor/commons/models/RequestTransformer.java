package com.flipkart.logisticsadaptor.commons.models;

/**
 * @param <R> :
 * @param <T> :
 */
public interface RequestTransformer<R, T> {

    public T getClientRequest(R request);
}