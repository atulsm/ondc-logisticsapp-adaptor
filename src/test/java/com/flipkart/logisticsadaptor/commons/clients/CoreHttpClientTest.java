package com.flipkart.logisticsadaptor.commons.clients;

import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.CoreHttpResponse;
import com.flipkart.logisticsadaptor.commons.utils.CustomObjectMapper;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.transformers.utils.EkartUtils;
import junit.framework.TestCase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;


public class CoreHttpClientTest extends TestCase {

    private static final String url = "/v1/offerings";
    private static final String host = "api.ekartlogistics.com";
    private static final int port = 443;
    CoreHttpClient coreHttpClient = new CoreHttpClient<>(host, 443, CoreHttpClient.HTTP_METHOD.POST,
            HttpClientBuilder.create().build(),
            CustomObjectMapper.getJavaType(CheckServiceabilityResponse.class), "TEST");

    @Test
    public void testExecuteSuccessful() throws Exception {


        ClientRequest clientRequest = ClientRequest.builder().headers(EkartUtils.getCommonEkartHeaders())
                .url(url)
                .body(getSLARequest())
                .build();

        CoreHttpResponse<CheckServiceabilityResponse> response = coreHttpClient.execute(clientRequest);
        CheckServiceabilityResponse slaResponse = response.getEntity();
        System.out.println(slaResponse);




    }

    private static SLARequest getSLARequest(){
        return SLARequest.builder()
                .seller_pincode("560014")
                .serviceType("FORWARD")
                .customer_pincode("560034").build();
    }


}
