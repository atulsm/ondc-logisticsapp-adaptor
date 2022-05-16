package com.flipkart.logisticsadaptor.utils;

import com.flipkart.logisticsadaptor.models.csv.PincodeCsvModel;
import junit.framework.TestCase;
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
        Assert.assertNotNull(pincodeList.get(0).getPincode());
        Assert.assertNotNull(pincodeList.get(0).getLatitude());
        Assert.assertNotNull(pincodeList.get(0).getLongitude());
    }






}