package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.Geocode;
import com.flipkart.logisticsadaptor.models.csv.PincodeCsvModel;
import com.flipkart.logisticsadaptor.utils.CSVUtils;

import javax.inject.Singleton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

@Singleton
public class LocalReverseGeocodeService implements ReverseGeocodeService{

    private static final String CSV_PATH = "src/main/resources/IN.csv";
    private HashMap<String, Integer> pincodeCsvModelHashMap = new HashMap<>();

    public LocalReverseGeocodeService()  {
        try {
            List<PincodeCsvModel> pincodeList =  CSVUtils.fetchInputRecords(new FileInputStream(new File(CSV_PATH)), PincodeCsvModel.class);
            pincodeList.forEach(entry -> {
                Geocode geocode = Geocode.builder()
                        .latitude(entry.getLatitude().toString())
                        .longitude(entry.getLongitude().toString())
                        .build();
                Integer pincode = Integer.parseInt(entry.getPincode().split("/")[1]);
                pincodeCsvModelHashMap.put(getHashForGeoCode(geocode), pincode);

            });
        }
        catch (Exception e){

        }
    }

    @Override
    public Integer getPincodeFromLatLong(Geocode geocode) {
        Integer pincode=pincodeCsvModelHashMap.get(getHashForGeoCode(geocode));
        if(pincode== null)return new Integer(560042);
        return pincode;
    }

    private String getHashForGeoCode(Geocode geocode){
        return String.format("%.4f",Double.parseDouble(geocode.getLatitude())) + "B" + String.format("%.4f" , Double.parseDouble(geocode.getLongitude()));
    }
}
