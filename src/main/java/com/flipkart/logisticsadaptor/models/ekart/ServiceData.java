package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.flipkart.logisticsadaptor.models.ekart.enums.DeliveryType;
import com.flipkart.logisticsadaptor.models.ekart.enums.FulfilmentType;
import com.flipkart.logisticsadaptor.models.ekart.enums.LogisticsType;
import com.flipkart.logisticsadaptor.models.ekart.enums.PaymentChannel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    private String pickupVendorName;

    private String fulfillmentType= FulfilmentType.NON_FBF.getName();

    private String logisticsType= LogisticsType.E2E_EKL.getName();

    private String amountToCollect;

    @Valid
    private List<ServiceType> serviceTypes;

    private String dispatchDate;

    private String customerPromiseDate;


    private String deliveryType = DeliveryType.SMALL.name();


    private String paymentChannel = PaymentChannel.COD.name();

    @NotNull(message = SOURCE_LOCATION_IS_NULL)
    private Locations source;

    @NotNull(message = DESTINATION_LOCATION_NULL)
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
