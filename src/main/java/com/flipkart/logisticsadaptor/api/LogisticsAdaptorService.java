package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.core.Bucket;
import com.flipkart.logisticsadaptor.db.BucketDao;

//TODO Implement juice dependency injection
public class LogisticsAdaptorService {
    public static LogisticsAdaptorService INSTANCE = new LogisticsAdaptorService();
    private LogisticsAdaptorService(){}
    private BucketDao dao;

    public void init(BucketDao dao){
        this.dao=dao;
    }

    public Bucket createBucket(String name, String value){
        return dao.create(new Bucket(name,value));
    }

    public Bucket getBucket(String name){
        return dao.find(name);
    }

    public void deleteBucket(String name){
        dao.delete(name);
    }

    public int count(){
        return 1; //TODO implement  a namedquery
    }

}
