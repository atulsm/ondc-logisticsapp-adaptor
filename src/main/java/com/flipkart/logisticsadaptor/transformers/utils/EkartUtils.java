package com.flipkart.logisticsadaptor.transformers.utils;

import com.flipkart.logisticsadaptor.engine.EkartConstants;
import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ekart.*;
import com.flipkart.logisticsadaptor.models.ekart.Address;
import com.flipkart.logisticsadaptor.models.ondc.common.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EkartUtils {

    private static final String HEADER_HTTP_X_MERCHANT_CODE = "HTTP_X_MERCHANT_CODE";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    public static Map<String, String> getCommonEkartHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put(HEADER_HTTP_X_MERCHANT_CODE, "JYN");
        headers.put(HEADER_AUTHORIZATION, "B");
        //headers.put(HEADER_CONTENT_TYPE, "application/json");
        return headers;
    }

    public static Descriptor getEkartDescriptor(){
        return Descriptor.builder()
                .name(EkartConstants.EKART_PROVIDER_NAME)
                .build();
    }

    public static Map<String, String>  getHeadersForMerchant(Merchant merchant){
        Map<String, String> headers = new HashMap<>();
        headers.put(HEADER_HTTP_X_MERCHANT_CODE, merchant.getMerchantCode());
        headers.put(HEADER_AUTHORIZATION, merchant.getAuthHeader());
        //headers.put(HEADER_CONTENT_TYPE, "application/json");
        return headers;
    }

    public static String getTrackingIdForMerchant(Merchant merchant , boolean isCod){
        String merchantCode = merchant.getMerchantCode();
        String payment = "C";
        if(!isCod)payment = "P";
        return merchantCode + payment + getUniqueId();
    }

    private static String getUniqueId(){
        LocalDate date =java.time.LocalDateTime.now().toLocalDate();
        String day = addPrefix(date.getDayOfMonth(), 2);
        String month = addPrefix(date.getMonth().getValue(), 2);
        LocalTime currentTime = java.time.LocalDateTime.now().toLocalTime();
        String time = addPrefix(currentTime.getHour(), 2) + addPrefix(currentTime.getMinute(), 2) + addPrefix(currentTime.getSecond(), 2);
        return  day + month + time;
    }

    private static String addPrefix(int num , int k){
        String inp = Integer.toString(num);
        int len = inp.length();
        while(len < k){
            len++;
            inp = "0" + inp;
        }
        return inp;
    }

    public static Address getStartAddress(Order order){
        Start start = order.getFulfillment().getStart();
        return getAddress(start.getContact(), start.getLocation(), start.getPerson());
    }

    public static Address getEndAddress(Order order){
        End end = order.getFulfillment().getEnd();
        return getAddress(end.getContact(),  end.getLocation(), end.getPerson());
    }

    public static Address getAddress(Contact contact, Location location, Person person){
        com.flipkart.logisticsadaptor.models.ondc.common.Address address = location.getAddress();
        return Address.builder()
                .emailId(contact.getEmail())
                .primaryContactNumber(contact.getPhone())
                .firstName(person.getName())
                .addressLine1(join(address.getDoor(),  ", " ,  address.getName()))
                .addressLine2(join(address.getBuilding(), ", ", address.getLocality(), " ,", address.getStreet()))
                .pincode(address.getAreaCode())
                .city(address.getCity())
                .state(address.getState())
                .build();
    }

    public static Integer getAmountInRupees(Order order){
        return Math.round(order.getQuote().getPrice().getValue());
    }

    public static Locations getLocationForAddress(Address address){
        return Locations.builder()
                .address(address)
                .build();
    }

    public static ShipmentDimension getShipmentDimensions(Order order){
        return ShipmentDimension.builder()
                .weight(new Weight(12))
                .build();

    }

    public static List<ShipmentItems> getShipmentItems(Order order){
        List<ShipmentItems> shipmentItems = new ArrayList<>();
        String orderId = order.getId();
        for(Item item: order.getItems()){
            shipmentItems.add(getShipmentItem(item, orderId, orderId));
        }
        return shipmentItems;
    }

    public static ShipmentItems getShipmentItem(Item item, String orderId , String invoiceId){
            ShipmentItems shipmentItems =  ShipmentItems.builder()
                                            .productId(item.getId())
                                            .quantity(item.getQuantity().getCount())
                                            .build();
            shipmentItems.setOrderId(orderId);
            shipmentItems.setInvoiceId(invoiceId);
            return shipmentItems;
    }

    public static String join(String... strings){
        String res = "";
        for(String s: strings){
            if(s != null && s.length() > 1){
                res = res + s + " ";
            }
        }
        return res;
    }





}
