package com.flipkart.logisticsadaptor.engine;

import com.flipkart.logisticsadaptor.commons.clients.BaseClient;
import com.flipkart.logisticsadaptor.models.ekart.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.common.Quotation;
import com.flipkart.logisticsadaptor.models.ondc.init.InitRequest;
import com.flipkart.logisticsadaptor.models.ondc.oninit.OnInitMessage;
import com.flipkart.logisticsadaptor.models.ondc.search.SearchRequest;
import com.flipkart.logisticsadaptor.api.QuotationService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import lombok.extern.slf4j.Slf4j;


@Singleton
@Slf4j
public class EkartAdaptorEngine {


    QuotationService quotationService;
    private BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient;
    private BaseClient<InitRequest, OnInitMessage> initRequestResponseMessageBaseClient;

    @Inject
    public void EkartAdaptorEngineSearch(@Named("EKartSearchClient") BaseClient<SearchRequest, OnSearchMessage> searchRequestResponseMessageBaseClient){
        this.searchRequestResponseMessageBaseClient = searchRequestResponseMessageBaseClient;
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


    @Inject
    public void EkartAdaptorEngineInit (@Named("EKartInitClient") BaseClient<InitRequest, OnInitMessage > initRequestResponseMessageBaseClient){
        this.initRequestResponseMessageBaseClient = initRequestResponseMessageBaseClient;
    }


    public OnInitMessage getInitResponse(InitRequest initRequest){
        try {
            OnInitMessage temp = initRequestResponseMessageBaseClient.execute(initRequest);
            temp.getOrder().setItems(initRequest.getMessage().getOrder().getItems());
            temp.getOrder().setBilling(initRequest.getMessage().getOrder().getBilling());
            temp.getOrder().setFulfillment(initRequest.getMessage().getOrder().getFulfillment());
            temp.getOrder().setQuote(quotationService.getQuotationForOrder(initRequest.getMessage().getOrder()));
            return temp;
        }
        catch (Exception e){
            log.error("Exception In getInitResponse : " + e.getMessage());
        }
        return null;
    }

}
