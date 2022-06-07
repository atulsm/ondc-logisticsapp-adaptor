package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.api.MerchantService;
import com.flipkart.logisticsadaptor.api.ReverseGeocodeService;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.commons.clients.BasicHttpClient;
import com.flipkart.logisticsadaptor.commons.clients.CoreHttpClient;
import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.commons.utils.CustomObjectMapper;
import com.flipkart.logisticsadaptor.models.ekart.CancelShipmentResponse;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ekart.CreateShipmentResponse;
import com.flipkart.logisticsadaptor.models.ondc.cancel.CancelRequest;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oncancel.OnCancelMessage;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.flipkart.logisticsadaptor.transformers.request_transformer.CancelRequestTransformer;
import com.flipkart.logisticsadaptor.transformers.request_transformer.ConfirmRequestTransformer;
import com.flipkart.logisticsadaptor.transformers.request_transformer.InitRequestTransformer;
import com.flipkart.logisticsadaptor.transformers.request_transformer.SearchRequestTransformer;
import com.flipkart.logisticsadaptor.transformers.response_transformer.CancelResponseTransformer;
import com.flipkart.logisticsadaptor.transformers.response_transformer.ConfirmResponseTransformer;
import com.flipkart.logisticsadaptor.transformers.response_transformer.InitResponseTransformer;
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
                                                                        ReverseGeocodeService reverseGeocodeService,
                                                                        MerchantService merchantService){
        return new BasicHttpClient<>(
                httpClient,
                new SearchRequestTransformer(reverseGeocodeService, merchantService),
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

    @Provides
    @Singleton
    @Named("EKartInitClient")
    @Inject
    BaseClient<InitRequest, OnInitMessage> provideEkartInitClient(@Named("EKartInitHttpClient")CoreHttpClient<CheckServiceabilityResponse> httpClient,
                                                                  ReverseGeocodeService reverseGeocodeService){
        return new BasicHttpClient<>(
                httpClient,
                new InitRequestTransformer(reverseGeocodeService),
                new InitResponseTransformer()
        );
    }

    @Provides
    @Singleton
    @Named("EKartInitHttpClient")
    @Inject
    CoreHttpClient<CheckServiceabilityResponse>  provideEkartInitHttpClient(EkartConfig ekartConfig){
        return new CoreHttpClient<>(ekartConfig.getEKartHost(),
                ekartConfig.getPort(),
                CoreHttpClient.HTTP_METHOD.POST,
                HttpClientBuilder.create().build(),
                CustomObjectMapper.getJavaType(CheckServiceabilityResponse.class),
                EkartConstants.INIT
        );
    }

    @Provides
    @Singleton
    @Named("EKartConfirmClient")
    @Inject
    BaseClient<AdaptorRequest, CreateShipmentResponse> provideEkartConfirmClient(@Named("EKartConfirmHttpClient") CoreHttpClient<CreateShipmentResponse> httpClient,
                                                                           ConfirmRequestTransformer confirmRequestTransformer,
                                                                           ConfirmResponseTransformer confirmResponseTransformer){
        return new BasicHttpClient<>(
                httpClient,
               confirmRequestTransformer,
               confirmResponseTransformer
        );
    }

    @Provides
    @Singleton
    @Named("EKartConfirmHttpClient")
    @Inject
    CoreHttpClient<CreateShipmentResponse>  provideEkartConfirmHttpClient(EkartConfig ekartConfig){
        return new CoreHttpClient<>(ekartConfig.getEkartStageHost(),
                ekartConfig.getPort(),
                CoreHttpClient.HTTP_METHOD.POST,
                HttpClientBuilder.create().build(),
                CustomObjectMapper.getJavaType(CreateShipmentResponse.class),
                EkartConstants.CONFIRM
        );
    }
    @Provides
    @Singleton
    @Named("EKartCancelClient")
    @Inject
    BaseClient<CancelRequest, OnCancelMessage> provideEkartCancelClient(@Named("EKartCancelHttpClient") CoreHttpClient<CancelShipmentResponse> httpClient
                                                                       ){
        return new BasicHttpClient<>(
                httpClient,
               new CancelRequestTransformer(),
                new CancelResponseTransformer()
        );
    }

    @Provides
    @Singleton
    @Named("EKartCancelHttpClient")
    @Inject
    CoreHttpClient<CancelShipmentResponse>  provideEkartCancelHttpClient(EkartConfig ekartConfig){
        return new CoreHttpClient<>(ekartConfig.getEkartStageHost(),
                ekartConfig.getPort(),
                CoreHttpClient.HTTP_METHOD.PUT,
                HttpClientBuilder.create().build(),
                CustomObjectMapper.getJavaType(CancelShipmentResponse.class),
                EkartConstants.CANCEL
        );
    }

}
