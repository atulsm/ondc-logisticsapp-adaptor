package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.flipkart.logisticsadaptor.models.ondc.common.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

/**
 * Created by vaibhav.janardhan on 27/09/16.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Locations {
    public static final String LOCATION_CODE_AND_ADDRESS_BOTH_ARE_NULL = "Location code and Address both are null";
    public static final String LOCATION_CODE_EXCEEDS_MAX_LENGTH = "Location code exceeds maximum allowed length - 120";
    @Valid
    private Address address;

    private String locationCode;

    private String locationName;

    private String locationId;


    private String sellerLocationId;

}
