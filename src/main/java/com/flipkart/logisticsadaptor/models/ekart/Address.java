package com.flipkart.logisticsadaptor.models.ekart;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Address {

    private String sellerId = "";

    private String addressId = "";

    private String firstName;

    private String attnName;

    private String addressLine1;

    private String addressLine2;

    private String pincode;

    private String city;

    private String state;

    private String primaryContactNumber;

    private String alternateContactNumber;

    private String landmark;

    private String emailId;

}
