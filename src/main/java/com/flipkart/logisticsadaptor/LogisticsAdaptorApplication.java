package com.flipkart.logisticsadaptor;

import com.flipkart.logisticsadaptor.api.LogisticsAdaptorService;
import com.flipkart.logisticsadaptor.core.Bucket;
import com.flipkart.logisticsadaptor.db.BucketDao;
import com.flipkart.logisticsadaptor.engine.EkartRegistryModule;
import com.flipkart.logisticsadaptor.guice.ServerModule;
import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.commons.models.internal.RateCard;
import com.flipkart.logisticsadaptor.resources.LogisticSearchResource;
import com.flipkart.logisticsadaptor.resources.LogisticsAdaptorResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class LogisticsAdaptorApplication extends Application<LogisticsAdaptorConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LogisticsAdaptorApplication().run(args);
    }

    private final HibernateBundle<LogisticsAdaptorConfiguration> hibernate = new HibernateBundle<LogisticsAdaptorConfiguration>(Bucket.class, Merchant.class, RateCard.class) {
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
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .modules(new ServerModule(hibernate), new EkartRegistryModule())
                .build());



    }

    @Override
    public void run(final LogisticsAdaptorConfiguration configuration,
                    final Environment environment) {
        final BucketDao dao = new BucketDao(hibernate.getSessionFactory());
        LogisticsAdaptorService.INSTANCE.init(dao);
        environment.jersey().register(new LogisticsAdaptorResource());
        environment.jersey().register(LogisticSearchResource.class);

    }


}
