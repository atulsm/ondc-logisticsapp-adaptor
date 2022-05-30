package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ShipmentDetails {

    private String clientReferenceId;

    private String trackingId;

    private String shipmentValue;

    @Valid
    private ShipmentDimension shipmentDimensions;

    private String returnLabelDesc_1;

    private String returnLabelDesc_2;

    @Valid
    private List<ShipmentItems> shipmentItems;
}
