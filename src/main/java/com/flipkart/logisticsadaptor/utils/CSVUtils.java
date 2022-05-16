package com.flipkart.logisticsadaptor.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class CSVUtils {
	private static Logger log;
    static {
    	log = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    	log.setLevel(Level.INFO);
    }
    
    public static <T> List<T> fetchInputRecords(InputStream uploadedInputStream, Class<T> type) throws Exception{
    	Level current = log.getLevel();
    	log.setLevel(Level.INFO);
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
        }finally {
    	 log.setLevel(current);
        }
    }


}
