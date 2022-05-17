package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class TierServiceabilityResponse {

    private boolean serviceable;

    @JsonProperty("SLA")
    private String sla;

    private String reason;

    @JsonProperty("packaging_requirement")
    private String packagingRequirement;

}
