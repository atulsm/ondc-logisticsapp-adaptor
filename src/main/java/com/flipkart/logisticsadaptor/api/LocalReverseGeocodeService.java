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
            pincodeList.stream().forEach(entry -> {


            });
        }
        catch (Exception e){

        }


    }

    @Override
    public Integer getPincodeFromLatLong(Geocode geocode) {
        return pincodeCsvModelHashMap.get(getHashForGeoCode(geocode));
    }

    private String getHashForGeoCode(Geocode geocode){
        return "test";
    }
}
