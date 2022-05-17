package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.commons.clients.BasicHttpClient;
import com.flipkart.logisticsadaptor.commons.clients.CoreHttpClient;
import com.flipkart.logisticsadaptor.commons.utils.CustomObjectMapper;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.response.ResponseMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.flipkart.logisticsadaptor.transformers.request_transformer.SearchRequestTransformer;
import com.flipkart.logisticsadaptor.transformers.response_transformer.SearchResponseTransformer;
import com.google.inject.Provides;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class EkartRegistry {


    @Provides
    @Singleton
    @Named("EKartSearchClient")
    BaseClient<SearchRequest, OnSearchMessage> provideEkartSearchClient(@Named("EKartSearchHttpClient") CoreHttpClient<CheckServiceabilityResponse> httpClient){
        return new BasicHttpClient<>(
                httpClient,
                new SearchRequestTransformer(),
                new SearchResponseTransformer()
        );
    }

    @Provides
    @Inject
    @Singleton
    @Named("EKartSearchHttpClient")
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
