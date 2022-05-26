// 
// Decompiled by Procyon v0.5.36
// 

package com.flipkart.logisticsadaptor.models.ondc.oninit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnInitMessage
{
    private Order order;
    
    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(final Order order) {
        this.order = order;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OnInitMessage)) {
            return false;
        }
        final OnInitMessage other = (OnInitMessage)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$order = this.getOrder();
        final Object other$order = other.getOrder();
        if (this$order == null) {
            if (other$order == null) {
                return true;
            }
        }
        else if (this$order.equals(other$order)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof OnInitMessage;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $order = this.getOrder();
        result = result * 59 + (($order == null) ? 43 : $order.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "OnInitMessage(order=" + this.getOrder() + ")";
    }
}
