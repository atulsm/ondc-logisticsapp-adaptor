package com.flipkart.logisticsadaptor.commons.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ClientRequest {
    // Post Body
    Object body;
    // Request Headers
    Map<String, String> headers;
    // Reuqest Url
    String url;
    // Request params
    List<KeyValue> params;

}