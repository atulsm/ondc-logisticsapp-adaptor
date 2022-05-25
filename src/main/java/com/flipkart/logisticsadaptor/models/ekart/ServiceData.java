package com.flipkart.logisticsadaptor.models.ekart;

import com.ekl.durin.v2.constraints.DateFormatValidator;
import com.ekl.durin.v2.constraints.EnumValidator;
import com.ekl.durin.v2.constraints.FutureDateValidator;
import com.ekl.durin.v2.constraints.Pattern;
import com.ekl.durin.v2.enums.DeliveryType;
import com.ekl.durin.v2.enums.FulfilmentType;
import com.ekl.durin.v2.enums.LogisticsType;
import com.ekl.durin.v2.enums.PaymentChannel;
import com.ekl.durin.v2.helpers.Constants;
import com.ekl.durin.v2.services.validationGroups.BasicValidation;
import com.ekl.durin.v2.services.validationGroups.CreateShipmentValidation;
import com.ekl.durin.v2.services.validationGroups.ReverseServiceValidation;
import com.ekl.durin.v2.services.validationGroups.UpdateShipmentValidation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sun.tools.javac.file.Locations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.ekl.durin.v2.helpers.Constants.REGX_FOR_FLOAT_VALUE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ServiceData {

    public static final String AMOUNT_TO_COLLECT_NULL_OR_EMPTY = "Amount to collect is Null or Empty";
    public static final String INVALID_AMOUNT_TO_COLLECT = "Amount to collect is Invalid";
    public static final String EXCEEDS_MAX_VALUE_FOR_REVERSE_SHIPMENT = "Amount to collect should be 0 for Reverse service";
    public static final String EXCEEDS_MAX_VALUE_FOR_COD = "Amount to collect should not exceed 50000";
    public static final String INVALID_DATE_FORMAT = "Invalid Date Format";
    public static final String INVALID_DELIVERY_TYPE = "Invalid delivery type";
    public static final String INVALID_PAYMENT_CHANNEL = "Invalid payment channel";
    public static final String SOURCE_LOCATION_IS_NULL = "Source location is Null";
    public static final String DESTINATION_LOCATION_NULL = "Destination location is Null";
    public static final String DELIVERY_TYPE_IS_NULL_OR_EMPTY = "Delivery Type is null or empty";
    public static final String PAYMENT_CHANNEL_IS_NULL_OR_EMPTY = "Payment channel is null or empty";
    public static final String INVALID_FULFILLMENT_TYPE = "Invalid fulfillment type";
    public static final String INVALID_LOGISTICS_TYPE = "Invalid logistics type";
    public static final String PAST_DATE = "Past dates not allowed";

    private List<String> vasTypes;

    private String vendorName;

    public String getVendorName() {
        if (StringUtils.isBlank(vendorName)) {
           this.vendorName= Constants.Vendors.DEFAULT_VENDOR_NAME;
        }
        return this.vendorName;
    }

    private String pickupVendorName;

    @EnumValidator(enumClass = FulfilmentType.class, message = INVALID_FULFILLMENT_TYPE, groups = {BasicValidation.class})
    private String fulfillmentType=FulfilmentType.NON_FBF.getName();

    @EnumValidator(enumClass = LogisticsType.class, message = INVALID_LOGISTICS_TYPE, groups = {BasicValidation.class})
    private String logisticsType=LogisticsType.E2E_EKL.getName();

    @NotBlank(message = AMOUNT_TO_COLLECT_NULL_OR_EMPTY, groups = {CreateShipmentValidation.class})
    @Pattern(regexp = REGX_FOR_FLOAT_VALUE, message = INVALID_AMOUNT_TO_COLLECT, groups = {BasicValidation.class})
    @Max(value = 0, message = EXCEEDS_MAX_VALUE_FOR_REVERSE_SHIPMENT, groups = {ReverseServiceValidation.class})
    @Range(max = 50000, message = EXCEEDS_MAX_VALUE_FOR_COD, groups = {CreateShipmentValidation.class})
    private String amountToCollect;

    @Valid
    private List<ServiceType> serviceTypes;

    @DateFormatValidator(message = INVALID_DATE_FORMAT, groups = {BasicValidation.class})
    @FutureDateValidator(message = PAST_DATE, groups = {UpdateShipmentValidation.class})
    private String dispatchDate;

    @DateFormatValidator(message = INVALID_DATE_FORMAT, groups = {BasicValidation.class})
    private String customerPromiseDate;

    @NotEmpty(message = DELIVERY_TYPE_IS_NULL_OR_EMPTY, groups = {BasicValidation.class})
    @EnumValidator(enumClass = DeliveryType.class, message = INVALID_DELIVERY_TYPE, groups = {BasicValidation.class})
    private String deliveryType = DeliveryType.SMALL.name();

    @NotEmpty(message = PAYMENT_CHANNEL_IS_NULL_OR_EMPTY, groups = {BasicValidation.class})
    @EnumValidator(enumClass = PaymentChannel.class, message = INVALID_PAYMENT_CHANNEL, groups = {BasicValidation.class})
    private String paymentChannel = PaymentChannel.COD.name();

    @NotNull(message = SOURCE_LOCATION_IS_NULL, groups = {CreateShipmentValidation.class})
    @Valid
    private Locations source;

    @NotNull(message = DESTINATION_LOCATION_NULL, groups = {CreateShipmentValidation.class})
    @Valid
    private Locations destination;

    @Valid
    private Locations returnLocation;

    @Valid
    private Locations originLocation;

    private Locations handoverLocation;

    private List<Pair> serviceAttributes;

    @JsonIgnore
    private String shipmentPaymentLink;

    @JsonIgnore
    private String shipmentPaymentReferenceId;

    private String handoverType = "source";

    private String destinationMhCode;
}
