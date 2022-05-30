package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ServiceType {

    private static final String NAME_IS_EMPTY_OR_NULL = "Service type name is empty or null";
    private static final String VALUE_IS_EMPTY_OR_NULL = "Service type value is empty or null";
    public static final String INVALID_SERVICE_TYPE = "Invalid service type";

    private String name;

    private String value;
}
