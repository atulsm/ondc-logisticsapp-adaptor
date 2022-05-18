package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.api.ReverseGeocodeService;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.commons.clients.BasicHttpClient;
import com.flipkart.logisticsadaptor.commons.clients.CoreHttpClient;
import com.flipkart.logisticsadaptor.commons.utils.CustomObjectMapper;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.flipkart.logisticsadaptor.transformers.request_transformer.SearchRequestTransformer;
import com.flipkart.logisticsadaptor.transformers.response_transformer.SearchResponseTransformer;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.apache.http.impl.client.HttpClientBuilder;


public class EkartRegistryModule extends AbstractModule {


    @Provides
    @Singleton
    @Named("EKartSearchClient")
    @Inject
    BaseClient<SearchRequest, OnSearchMessage> provideEkartSearchClient(@Named("EKartSearchHttpClient") CoreHttpClient<CheckServiceabilityResponse> httpClient,
                                                                        ReverseGeocodeService reverseGeocodeService){
        return new BasicHttpClient<>(
                httpClient,
                new SearchRequestTransformer(reverseGeocodeService),
                new SearchResponseTransformer()
        );
    }

    @Provides
    @Singleton
    @Named("EKartSearchHttpClient")
    @Inject
    CoreHttpClient<CheckServiceabilityResponse>  provideEkartSearchHttpClient(EkartConfig ekartConfig){
        return new CoreHttpClient<>(ekartConfig.getEKartHost(),
               ekartConfig.getPort(),
                CoreHttpClient.HTTP_METHOD.POST,
                HttpClientBuilder.create().build(),
                CustomObjectMapper.getJavaType(CheckServiceabilityResponse.class),
                EkartConstants.SEARCH
        );
    }

}
