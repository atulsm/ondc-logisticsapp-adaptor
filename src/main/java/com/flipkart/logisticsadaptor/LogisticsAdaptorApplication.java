package com.flipkart.logisticsadaptor;

import com.flipkart.logisticsadaptor.api.LogisticsAdaptorService;
import com.flipkart.logisticsadaptor.core.Bucket;
import com.flipkart.logisticsadaptor.db.BucketDao;
import com.flipkart.logisticsadaptor.resources.LogisticSearchResource;
import com.flipkart.logisticsadaptor.resources.LogisticsAdaptorResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

public class LogisticsAdaptorApplication extends Application<LogisticsAdaptorConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LogisticsAdaptorApplication().run(args);
    }

    private final HibernateBundle<LogisticsAdaptorConfiguration> hibernate = new HibernateBundle<LogisticsAdaptorConfiguration>(Bucket.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(LogisticsAdaptorConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "LogisticsAdaptorApplication";
    }

    @Override
    public void initialize(final Bootstrap<LogisticsAdaptorConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final LogisticsAdaptorConfiguration configuration,
                    final Environment environment) {
        final BucketDao dao = new BucketDao(hibernate.getSessionFactory());
        LogisticsAdaptorService.INSTANCE.init(dao);
        environment.jersey().register(new LogisticsAdaptorResource());
        environment.jersey().register(new LogisticSearchResource());

    }


}
