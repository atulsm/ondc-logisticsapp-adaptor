package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.flipkart.logisticsadaptor.models.ekart.enums.GoodsCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class CreateShipmentRequest {
    private String requestId = UUID.randomUUID().toString();
    private String clientName;
    private String goodsCategory = GoodsCategory.NON_ESSENTIAL.name();
    private List<Service> services;


    @JsonIgnore
    private MerchantDetails merchantDetails;

    @JsonIgnore
    public List<String> getTrackingIds(){
        List<String> trackingIds = new ArrayList<>();
        for(Service service: services){
            for(ServiceDetail serviceDetail: service.getServiceDetails()){
                trackingIds.add(serviceDetail.getShipment().getTrackingId());
            }
        }
        return trackingIds;
    }

}
