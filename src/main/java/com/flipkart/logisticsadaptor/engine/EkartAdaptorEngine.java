package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.api.MerchantService;
import com.flipkart.logisticsadaptor.api.PaymentDetailsService;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.commons.models.AdaptorRequest;
import com.flipkart.logisticsadaptor.models.ekart.CreateShipmentResponse;
import com.flipkart.logisticsadaptor.models.ekart.ResponsePayload;
import com.flipkart.logisticsadaptor.models.ondc.confirm.OnConfirmMessage;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.ontrack.OnTrackMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.flipkart.logisticsadaptor.api.QuotationService;
import com.flipkart.logisticsadaptor.models.ondc.track.TrackRequest;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Singleton
@Slf4j
public class EkartAdaptorEngine {


    @Inject
    private QuotationService quotationService;
    @Inject
    private MerchantService merchantService;
    @Inject
    private PaymentDetailsService paymentDetailsService;

    @Inject
    @Named("EKartSearchClient")
    private BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient;

    @Inject
    @Named("EKartInitClient")
    private BaseClient<InitRequest, OnInitMessage> initRequestResponseMessageBaseClient;

    @Inject
    @Named("EKartConfirmClient")
    private BaseClient<AdaptorRequest, CreateShipmentResponse> confirmBaseClient;



    public OnSearchMessage getSearchResponse(SearchRequest searchRequest){
        try {
            return searchRequestResponseMessageBaseClient.execute(searchRequest);
        }
        catch (Exception e){
            log.error("Exception In getSearchResponse : " + e.getMessage());
        }
       return null;
    }

    public OnTrackMessage getTrackResponse(TrackRequest trackRequest){
        try{

        }
        catch (Exception e){
            log.error("Exception In getSearchResponse : " + e.getMessage());
        }
        return null;
    }


    public OnInitMessage getInitResponse(InitRequest initRequest){
        try {
            OnInitMessage temp = initRequestResponseMessageBaseClient.execute(initRequest);
            temp.getOrder().setItems(initRequest.getMessage().getOrder().getItems());
            temp.getOrder().setBilling(initRequest.getMessage().getOrder().getBilling());
            temp.getOrder().setFulfillment(initRequest.getMessage().getOrder().getFulfillment());
            temp.getOrder().setQuote(quotationService.getQuotationForOrder(initRequest.getMessage().getOrder(),merchantService.getMerchantDetails(initRequest.getContext().getBapId())));
            temp.getOrder().setPayment(paymentDetailsService.getPaymentDetails(temp.getOrder(),merchantService.getMerchantDetails(initRequest.getContext().getBapId())));
            return temp;
        }
        catch (Exception e){
            log.error("Exception In getIitResponse : " + e.getMessage());
        }
        return null;
    }

    public AdaptorRequest processOrder(AdaptorRequest adaptorRequest) throws Exception{
        CreateShipmentResponse createShipmentResponse  = confirmBaseClient.execute(adaptorRequest);
        for(ResponsePayload responsePayload: createShipmentResponse.getResponse()){
            adaptorRequest.setTrackingId(responsePayload.getTrackingId());
            adaptorRequest.setOrderStatus(responsePayload.getStatus());
            adaptorRequest.getOrder().setState(responsePayload.getStatus());
        }
        adaptorRequest.setCreateShipmentResponse(createShipmentResponse);
        return adaptorRequest;
    }

}
