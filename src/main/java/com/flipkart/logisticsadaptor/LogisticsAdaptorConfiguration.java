package com.flipkart.logisticsadaptor;

import com.flipkart.logisticsadaptor.engine.EkartConfig;
import com.google.inject.Singleton;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Singleton
public class LogisticsAdaptorConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @Valid
    @NotNull
    @JsonProperty("ekart")
    private EkartConfig ekartConfig;

    public EkartConfig getEkartConfig(){return ekartConfig;};
}
