package com.flipkart.logisticsadaptor.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class CSVUtils {

    public static <T> List<T> fetchInputRecords(InputStream uploadedInputStream, Class<T> type) throws Exception{
        try {
            Reader inputReader = new InputStreamReader(uploadedInputStream);
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(inputReader)
                    .withType(type)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            log.error("Exception while converting the csv record :{} ", e);
            throw e;
        }
    }


}
