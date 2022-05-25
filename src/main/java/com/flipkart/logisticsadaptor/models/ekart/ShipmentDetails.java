package com.flipkart.logisticsadaptor.models.ekart;

import com.ekl.durin.v2.constraints.NotZero;
import com.ekl.durin.v2.constraints.Pattern;
import com.ekl.durin.v2.services.validationGroups.BasicValidation;
import com.ekl.durin.v2.services.validationGroups.CreateShipmentValidation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

import static com.ekl.durin.v2.helpers.Constants.REGX_FOR_FLOAT_VALUE;

/**
 * Created by vaibhav.janardhan on 29/09/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ShipmentDetails {

    public static final String EMPTY_TRACKING_ID = "Tracking Id can not be empty";
    public static final String INVALID_TRACKING_ID = "Invalid tracking ID";
    public static final String INVALID_SHIPMENT_VALUE = "Shipment value is Invalid";
    public static final String EMPTY_SHIPMENT_ITEMS = "Shipment Items can not be empty";
    public static final String DIMENSION_IS_NULL = "Shipment dimensions is Null";

    private String clientReferenceId;

    @NotEmpty(message = EMPTY_TRACKING_ID, groups = {CreateShipmentValidation.class})
    private String trackingId;

    private String pickupTrackingId;

    private List<String> associatedTrackingIds;

    @Pattern(regexp = REGX_FOR_FLOAT_VALUE, message = INVALID_SHIPMENT_VALUE, groups = {BasicValidation.class})
    @NotEmpty(message = INVALID_SHIPMENT_VALUE, groups = {CreateShipmentValidation.class})
    @NotZero(message = INVALID_SHIPMENT_VALUE, groups = {CreateShipmentValidation.class})
    private String shipmentValue;

    @Valid
    private ShipmentDimension shipmentDimensions;

    private String returnLabelDesc_1;

    private String returnLabelDesc_2;

    @NotEmpty(message = EMPTY_SHIPMENT_ITEMS, groups = {CreateShipmentValidation.class})
    @Valid
    private List<ShipmentItems> shipmentItems;
}
