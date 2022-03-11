package com.flipkart.logisticsadaptor.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import com.flipkart.logisticsadaptor.core.Bucket;

public class BucketDao extends AbstractDAO<Bucket> {
    public BucketDao(SessionFactory factory) {
        super(factory);
    }

    public Bucket find(String bucketName) {
        return get(bucketName);
    }

    public Bucket create(Bucket bucket) {
        return persist(bucket);
    }

    public void delete(String bucketName){
        currentSession().delete(find(bucketName));
    }
}
