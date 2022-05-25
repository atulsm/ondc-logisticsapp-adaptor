package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.logisticsadaptor.models.ekart.enums.ServiceTypes;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SLARequest {
    @JsonProperty("request_id")
    private String requestId = UUID.randomUUID().toString();
    private String dispatch_date;
    private String customer_pincode;
    private String seller_pincode;
    private String rto_pincode;
    private String weight;
    private String height;
    private String breadth;
    private String length;
    private String delivery_type;
    @JsonProperty("service_type")
    private String serviceType;
    @JsonProperty("is_dangerous")
    private Boolean isDangerous = false;
    @JsonProperty("is_fragile")
    private Boolean isFragile = false;

    @JsonIgnore
    public boolean isForward() {
        return this.serviceType.equalsIgnoreCase(ServiceTypes.FORWARD.name());
    }

    @JsonIgnore
    public boolean isReverse() {
        return this.serviceType.equalsIgnoreCase(ServiceTypes.REVERSE.name());
    }
    @JsonIgnore
    public boolean isExchange() {
        return this.serviceType.equalsIgnoreCase(ServiceTypes.PREXO.name()) || this.serviceType.equalsIgnoreCase(ServiceTypes.REPLACEMENT.name());
    }

    @JsonIgnore
    public String getForwardRequestID() {
        return requestId.concat(Constant.LPEConstant.FORWARD);
    }

    @JsonIgnore
    public String getReverseRequestID() {
        return requestId.concat(Constant.LPEConstant.REVERSE);
    }

}
