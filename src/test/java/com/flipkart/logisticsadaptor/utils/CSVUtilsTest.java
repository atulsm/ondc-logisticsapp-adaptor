package com.flipkart.logisticsadaptor.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.logisticsadaptor.models.PincodeCsvModel;
import com.opencsv.bean.CsvBindByName;
import junit.framework.TestCase;
import lombok.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;


public class CSVUtilsTest extends TestCase {

    private static final String path = "src/main/resources/IN.csv";

    @Test
    public static void testCsv() throws Exception{
        List<PincodeCsvModel> pincodeList =  CSVUtils.fetchInputRecords(new FileInputStream(new File(path)), PincodeCsvModel.class);
        Assert.assertNotNull(pincodeList.get(0).getKey());
        Assert.assertNotNull(pincodeList.get(0).getLatitude());
        Assert.assertNotNull(pincodeList.get(0).getLongitude());
    }






}