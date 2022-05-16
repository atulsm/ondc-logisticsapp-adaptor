package com.flipkart.logisticsadaptor.commons.clients;


import com.flipkart.logisticsadaptor.commons.models.ClientRequest;
import com.flipkart.logisticsadaptor.commons.models.CoreHttpResponse;
import com.flipkart.logisticsadaptor.commons.models.RequestTransformer;
import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;

/**
 * @param <R> : Request object to client
 * @param <I> : Upstream response class
 * @param <F> : Final response class of the client that is understood by the platform
 */
public class BasicHttpClient<R, I, F> implements BaseClient<R, F> {
    private CoreHttpClient<I> httpClient;
    private ResponseTransformer<I, F> responseTransformer;
    private RequestTransformer<R, ClientRequest> requestTransformer;


    /**
     * @param httpClient          : httpClient
     * @param requestTransformer  : requestTransformer
     * @param responseTransformer : responseTransformer
     */
    public BasicHttpClient(CoreHttpClient httpClient,
                           RequestTransformer<R, ClientRequest> requestTransformer,
                           ResponseTransformer<I, F>  responseTransformer) {
        this.httpClient = httpClient;
        this.responseTransformer = responseTransformer;
        this.requestTransformer = requestTransformer;
    }

    public F execute(R request) throws Exception {
        ClientRequest clientRequest = requestTransformer.getClientRequest(request);
        CoreHttpResponse<I> response = httpClient.execute(clientRequest);
        return responseTransformer.convertResponse(response.getEntity());
    }
}
