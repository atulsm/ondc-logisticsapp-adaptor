package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.flipkart.logisticsadaptor.models.ekart.enums.PackingPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by vaibhav.janardhan on 27/09/16.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ServiceDetail {

    private String tier;

    @NotNull(message = "Service leg is null")
    private String serviceLeg;
    @NotNull(message = "Service data is null")
    @Valid
    private ServiceData serviceData;
    @NotNull(message = "Shipments are null")
    @Valid
    private ShipmentDetails shipment;

    @JsonIgnore
    private String movementType;

    private PackingPolicy packingPolicy = PackingPolicy.DEFAULT;

    @JsonIgnore
    public String serviceRequestType;
}
