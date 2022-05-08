package com.flipkart.logisticsadaptor.commons.models;

/**
 * Interface for response transformer.
 *
 * @param <R> : Internal response
 * @param <T> : Final response class (Platform understandable response class)
 */
public interface ResponseTransformer<R, T> {
    T convertResponse(R responseTransformerInput);
}
