package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.api.MerchantService;
import com.flipkart.logisticsadaptor.api.PaymentDetailsService;
import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.flipkart.logisticsadaptor.api.QuotationService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import lombok.extern.slf4j.Slf4j;


@Singleton
@Slf4j
public class EkartAdaptorEngine {


    private QuotationService quotationService;
    private MerchantService merchantService;
    private PaymentDetailsService paymentDetailsService;

    @Inject
    @Named("EKartSearchClient")
    private BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient;

    @Inject
    @Named("EKartInitClient")
    private BaseClient<InitRequest, OnInitMessage> initRequestResponseMessageBaseClient;


    public  EkartAdaptorEngine(BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient,BaseClient<InitRequest, OnInitMessage > initRequestResponseMessageBaseClient,MerchantService merchantService,QuotationService quotationService,PaymentDetailsService paymentDetailsService){
        this.searchRequestResponseMessageBaseClient = searchRequestResponseMessageBaseClient;
        this.initRequestResponseMessageBaseClient = initRequestResponseMessageBaseClient;
        this.quotationService=quotationService;
        this.merchantService=merchantService;
        this.paymentDetailsService=paymentDetailsService;
    }


    public OnSearchMessage getSearchResponse(SearchRequest searchRequest){
        try {
            return searchRequestResponseMessageBaseClient.execute(searchRequest);
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

}
