package com.flipkart.logisticsadaptor.commons.clients;

import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.CoreHttpResponse;
import com.flipkart.logisticsadaptor.commons.utils.CustomObjectMapper;
import com.flipkart.logisticsadaptor.models.ekart.SLARequest;
import com.flipkart.logisticsadaptor.models.ekart.SLAResponse;
import com.flipkart.logisticsadaptor.transformers.utils.EkartUtils;
import com.flipkart.logisticsadaptor.wiremock.MockServer;
import junit.framework.TestCase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;


public class CoreHttpClientTest extends TestCase {

    private static final String url = "/v1/offerings";
    private static final String host = "staging.ekartlogistics.com";
    private static final int port = 443;
    CoreHttpClient coreHttpClient = new CoreHttpClient<>(host, port, CoreHttpClient.HTTP_METHOD.POST,
            HttpClientBuilder.create().build(),
            CustomObjectMapper.getJavaType(SLAResponse.class), "TEST");

    @Test
    public void testExecuteSuccessful() throws Exception {


        ClientRequest clientRequest = ClientRequest.builder().headers(EkartUtils.getCommonEkartHeaders())
                .url(url)
                .body(getSLARequest())
                .build();

        CoreHttpResponse<SLAResponse> response = coreHttpClient.execute(clientRequest);
        SLAResponse slaResponse = response.getEntity();
        System.out.println(slaResponse);




    }

    private static SLARequest getSLARequest(){
        return SLARequest.builder()
                .request_id("82b317b3-8c7c-4fdd-1c78-6726f6e67f3b")
                .dispatch_date("2022-05-11 23:30:00")
                .seller_pincode("560034")
                .rto_pincode("560034")
                .service_type("FORWARD")
                .customer_pincode("560033").build();
    }


}
