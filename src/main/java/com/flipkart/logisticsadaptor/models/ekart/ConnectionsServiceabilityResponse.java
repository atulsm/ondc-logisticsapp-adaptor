package com.flipkart.logisticsadaptor.models.ekart;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ConnectionsServiceabilityResponse {


    @JsonProperty("REGULAR")
    private TierServiceabilityResponse regular;

    @JsonProperty("ECONOMY")
    private TierServiceabilityResponse economy;

    @JsonProperty("EXPRESS")
    private TierServiceabilityResponse express;

    @JsonProperty("PREMIUM")
    private TierServiceabilityResponse premium;

}

