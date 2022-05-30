package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ShipmentItems {

    private String productId;

    private ItemContent itemContent;

    private String category;

    private String productTitle;

    private Integer quantity;

    @Valid
    private Cost cost;

    @Valid
    private SellerDetail sellerDetails;

    private String legalEntity;

    private String billableEntity;

    private String codRemittanceEntity;

    private String hsn;

    private String ern;

    @JsonIgnore
    private String uniqueId;

    private String discount;

    private List<Pair> itemAttributes;

    private List<Pair> handlingAttributes;

    private PickupInfo pickupInfo;


    @JsonIgnore
    private boolean fragile;

    @JsonIgnore
    private boolean dangerous;

    public void setOrderId(String orderId){
        Pair pair = new Pair("order_id", orderId);
        if(itemAttributes == null) itemAttributes = new ArrayList<>();
        itemAttributes.add(pair);
    }

    public void setInvoiceId(String invoiceId){
        Pair pair = new Pair("invoice_id", invoiceId);
        if(itemAttributes == null) itemAttributes = new ArrayList<>();
        itemAttributes.add(pair);
    }




}
