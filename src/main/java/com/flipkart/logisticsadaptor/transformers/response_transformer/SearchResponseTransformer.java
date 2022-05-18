package com.flipkart.logisticsadaptor.transformers.response_transformer;


import com.flipkart.logisticsadaptor.commons.models.ResponseTransformer;
import com.flipkart.logisticsadaptor.engine.EkartConstants;
import com.flipkart.logisticsadaptor.models.ekart.CheckServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ekart.ConnectionsServiceabilityResponse;
import com.flipkart.logisticsadaptor.models.ondc.OnSearchMessage;
import com.flipkart.logisticsadaptor.models.ondc.common.Catalog;
import com.flipkart.logisticsadaptor.models.ondc.common.Category;
import com.flipkart.logisticsadaptor.models.ondc.common.Descriptor;
import com.flipkart.logisticsadaptor.models.ondc.common.Provider;
import com.flipkart.logisticsadaptor.transformers.utils.EkartUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResponseTransformer  implements ResponseTransformer<CheckServiceabilityResponse, OnSearchMessage> {


    @Override
    public OnSearchMessage convertResponse(CheckServiceabilityResponse responseTransformerInput) {
        return OnSearchMessage.builder()
                .catalog(getCatalogForContext(responseTransformerInput))
                .build();
    }

    private Catalog getCatalogForContext(CheckServiceabilityResponse checkServiceabilityResponse){
        return Catalog.builder()
                .bppDescriptor(EkartUtils.getEkartDescriptor())
                .bppProviders(Arrays.asList(getEkartProvider(checkServiceabilityResponse)))
                .build();
    }

    private Provider getEkartProvider(CheckServiceabilityResponse checkServiceabilityResponse){
        return Provider.builder()
                .id(EkartConstants.EKART_PROVIDER_ID)
                .descriptor(EkartUtils.getEkartDescriptor())
                .categories(getCategories(checkServiceabilityResponse))
                .build();
    }

    private List<Category> getCategories(CheckServiceabilityResponse checkServiceabilityResponse){
        List<Category> categories = new ArrayList<>();
        if(checkServiceabilityResponse.getConnections() != null){
            ConnectionsServiceabilityResponse connectionsServiceabilityResponse = checkServiceabilityResponse.getConnections();
            if(connectionsServiceabilityResponse.getEconomy() != null){
                categories.add(getCategoryForTier(EkartConstants.ECONOMY, EkartConstants.ECONOMY));
            }
            if(connectionsServiceabilityResponse.getRegular() != null){
                categories.add(getCategoryForTier(EkartConstants.REGULAR, EkartConstants.REGULAR));
            }
            if(connectionsServiceabilityResponse.getPremium() != null){
                categories.add(getCategoryForTier(EkartConstants.PREMIUM, EkartConstants.PREMIUM));
            }
            if(connectionsServiceabilityResponse.getExpress() != null){
                categories.add(getCategoryForTier(EkartConstants.EXPRESS, EkartConstants.EXPRESS));
            }

        }
        return categories;
    }

    private Category getCategoryForTier(String id , String name){
        return Category.builder()
                .id(id)
                .descriptor(Descriptor.builder()
                        .name(name)
                        .build())
                .build();
    }


}
