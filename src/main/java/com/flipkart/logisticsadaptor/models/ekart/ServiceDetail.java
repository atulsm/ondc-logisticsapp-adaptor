package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.flipkart.logisticsadaptor.models.ekart.enums.PackingPolicy;
import com.flipkart.logisticsadaptor.models.ekart.enums.ServiceLegs;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ServiceDetail {

    private String tier;

    @Builder.Default
    private String serviceLeg = ServiceLegs.FORWARD.name();
    @NotNull(message = "Service data is null")
    @Valid
    private ServiceData serviceData;
    @NotNull(message = "Shipments are null")
    @Valid
    private ShipmentDetails shipment;

    @Builder.Default
    private PackingPolicy packingPolicy = PackingPolicy.DEFAULT;

    @JsonIgnore
    public String serviceRequestType;
}
