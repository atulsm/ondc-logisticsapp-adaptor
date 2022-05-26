package com.flipkart.logisticsadaptor.models.ekart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
@Builder
public class CheckServiceabilityResponse {

    private String requestId;
    private boolean serviceable;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isServiceable() {
        return serviceable;
    }

    public void setServiceable(boolean serviceable) {
        this.serviceable = serviceable;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public Boolean getCOD() {
        return COD;
    }

    public void setCOD(Boolean COD) {
        this.COD = COD;
    }

    public Boolean getRVP() {
        return RVP;
    }

    public void setRVP(Boolean RVP) {
        this.RVP = RVP;
    }

    public Boolean getPrexo() {
        return prexo;
    }

    public void setPrexo(Boolean prexo) {
        this.prexo = prexo;
    }

    public Double getPrepaidLimit() {
        return prepaidLimit;
    }

    public void setPrepaidLimit(Double prepaidLimit) {
        this.prepaidLimit = prepaidLimit;
    }

    public Double getCodLimit() {
        return codLimit;
    }

    public void setCodLimit(Double codLimit) {
        this.codLimit = codLimit;
    }

    public String getAllowedGoodsCategory() {
        return allowedGoodsCategory;
    }

    public void setAllowedGoodsCategory(String allowedGoodsCategory) {
        this.allowedGoodsCategory = allowedGoodsCategory;
    }

    public ConnectionsServiceabilityResponse getConnections() {
        return connections;
    }

    public void setConnections(ConnectionsServiceabilityResponse connections) {
        this.connections = connections;
    }

    private String lane;
    private Boolean COD;
    private Boolean RVP;
    private Boolean prexo;
    private Double prepaidLimit;
    private Double codLimit;
    private String allowedGoodsCategory;
    @JsonProperty("connections")
    private ConnectionsServiceabilityResponse connections;

}
