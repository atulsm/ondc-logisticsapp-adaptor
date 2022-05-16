package com.flipkart.logisticsadaptor.commons.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoreHttpResponse<T> {
    T entity;
    Map<String, String> responseHeadersMap = new HashMap<>();
}
