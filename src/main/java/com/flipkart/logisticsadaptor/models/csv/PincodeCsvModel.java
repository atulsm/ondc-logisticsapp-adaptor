package com.flipkart.logisticsadaptor.models.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PincodeCsvModel {
        @CsvBindByName(column = "key")
        private String pincode ;
        @CsvBindByName(column = "place_name")
        private String place_name;
        @CsvBindByName(column = "admin_name1")
        private String admin_name1;
        @CsvBindByName(column = "latitude")
        private Double latitude;
        @CsvBindByName(column = "longitude")
        private Double longitude;
        @CsvBindByName(column = "accuracy", required = false)
        private int accuracy;
}
