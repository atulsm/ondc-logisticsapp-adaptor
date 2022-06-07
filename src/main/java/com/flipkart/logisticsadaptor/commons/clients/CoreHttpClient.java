package com.flipkart.logisticsadaptor.commons.clients;


import com.fasterxml.jackson.databind.JavaType;
import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.CoreHttpResponse;
import com.flipkart.logisticsadaptor.commons.models.KeyValue;
import com.flipkart.logisticsadaptor.commons.utils.CustomObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


/**
 * This is the Base Http Client.
 * It has the following params:
 * _host               : Ip of the elb of the service
 * _port               : Exposed port of the service
 * _scheme             : http/https
 * _httpClient         : HttpClient instance (Injected)
 *
 * @param <T> : final response class of the client that is understood by the platform
 */
@Getter
@Setter
@Slf4j
public class CoreHttpClient<T> {
    private static final String SCHEME = "https";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String UTF8 = "UTF-8";

    public enum HTTP_METHOD {
        POST,
        GET,
        PUT;
    }

    private HttpClient httpClient;
    private String host;
    private int port;
    private HTTP_METHOD httpMethod;
    private JavaType responseJavaType;
    private String clientName;
    private Integer timeoutInMillis;


    /**
     *
     * @param host             : Host IP
     * @param port             : Port
     * @param httpMethod       : Method (GET/POST/DELETE/PUT)
     * @param httpClient       : Http Client
     * @param responseJavaType : JavaType for the response object
     * @param clientName       : Client Name
     */
    public CoreHttpClient(
            String host,
            int port,
            HTTP_METHOD httpMethod,
            HttpClient httpClient,
            JavaType responseJavaType,
            String clientName
    ) {

        this.host = host;
        this.port = port;
        this.httpClient = httpClient;
        this.httpMethod = httpMethod;
        this.responseJavaType = responseJavaType;
        this.clientName = clientName;
        this.timeoutInMillis = null;
    }


    public CoreHttpResponse<T> execute(ClientRequest request) throws Exception {
        HttpUriRequest httpUriRequest = null;
        switch (httpMethod) {
            case GET:
                httpUriRequest = createGetRequest(request);
                break;
            case POST:
                httpUriRequest = createPostRequest(request);
                break;
            case PUT:
                httpUriRequest= createPutRequest(request);
            default:
                break;
        }

        return call(httpUriRequest);
    }

    private HttpPost createPostRequest(ClientRequest request) throws Exception {
        HttpPost httpPost = new HttpPost();
        httpPost.setURI(getRequestUri(request));
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }
        httpPost.setEntity(new StringEntity(
                    CustomObjectMapper.getObjectAsString(request.getBody()),
                    "application/json",
                UTF8
            ));
        return httpPost;
    }

    private HttpPut createPutRequest(ClientRequest request) throws Exception {
        HttpPut httpPut=new HttpPut();
        httpPut.setURI(getRequestUri(request));
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpPut.addHeader(entry.getKey(), entry.getValue());
        }
        httpPut.setEntity(new StringEntity(
                CustomObjectMapper.getObjectAsString(request.getBody()),
                "application/json",
                UTF8
        ));
        return httpPut;
    }



    private URI getRequestUri(ClientRequest request) throws URISyntaxException {
        // Create Url
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme(SCHEME)
                .setHost(host)
                .setPath(request.getUrl());
        // Add url params
        if (request.getParams() != null) {
            for (KeyValue keyValue : request.getParams()) {
                uriBuilder.addParameter(keyValue.getKey(), keyValue.getValue());
            }
        }
        return uriBuilder.build();
    }

    private HttpGet createGetRequest(ClientRequest request) throws Exception {
        HttpGet httpGet = new HttpGet();
        // Add headers
        if (MapUtils.isNotEmpty(request.getHeaders())) {
            for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        httpGet.setURI(getRequestUri(request));
        return httpGet;
    }

    private CoreHttpResponse<T> call(HttpUriRequest httpUriRequest) throws Exception {
        log.info(this.clientName , httpUriRequest);
        HttpResponse resp = httpClient.execute(httpUriRequest);
        log.info(this.clientName , resp);
        return deserializeClientResponse(resp);
    }

    private CoreHttpResponse<T> deserializeClientResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();

        String response = null;

        try {
            if (httpResponse.getEntity() != null)
                response = EntityUtils.toString(httpResponse.getEntity(), UTF8);
        } catch (Exception e) {
            log.error("Failed to parse response for client: {}", clientName, e);
        }
        if (statusCode / 100 != 2) {
            throw new ClientProtocolException(this.getClass().getSimpleName()
                    + " Returned : "
                    + Integer.toString(statusCode)
            );
        }

        Map<String, String> responseHeadersMap = new HashMap<>();
        for (Header header : httpResponse.getAllHeaders())
            responseHeadersMap.put(header.getName(), header.getValue());

        if (StringUtils.isNotBlank(response)) {
            try {
                CoreHttpResponse<T> resp = new CoreHttpResponse<>(
                        CustomObjectMapper.convertStringToObject(response, responseJavaType), responseHeadersMap
                );
                return resp;
            }
            catch (Exception e) {
                log.error("Failed inside Core Http Client for {} with exception ", clientName, e);
            }
        }
        return null;
    }

}
