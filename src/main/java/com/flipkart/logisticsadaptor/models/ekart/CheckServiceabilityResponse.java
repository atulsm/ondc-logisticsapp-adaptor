package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
@Builder
public class CheckServiceabilityResponse {

    private String requestId;
    private boolean serviceable;
    private String lane;
    private Boolean COD;
    private Boolean RVP;
    private Boolean prexo;
    private Double prepaidLimit;
    private Double codLimit;
    private String allowedGoodsCategory;
    @JsonProperty("connections")
    private ConnectionsServiceabilityResponse connections;

}
