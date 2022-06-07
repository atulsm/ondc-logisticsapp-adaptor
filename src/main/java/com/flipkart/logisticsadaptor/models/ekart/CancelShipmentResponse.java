package com.flipkart.logisticsadaptor.models.ekart;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
@Builder
public class CancelShipmentResponse {
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<ResponseDetails> getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(List<ResponseDetails> responseDetails) {
        this.responseDetails = responseDetails;
    }

    @Builder.Default
    private String requestId;
    private List<ResponseDetails> responseDetails;

}
