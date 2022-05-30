// 
// Decompiled by Procyon v0.5.36
// 

package com.flipkart.logisticsadaptor.models.ondc.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemQuantity
{
    private int count;
    private Object measure;
    
    public int getCount() {
        return this.count;
    }
    
    public Object getMeasure() {
        return this.measure;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
    public void setMeasure(final Object measure) {
        this.measure = measure;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ItemQuantity)) {
            return false;
        }
        final ItemQuantity other = (ItemQuantity)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getCount() != other.getCount()) {
            return false;
        }
        final Object this$measure = this.getMeasure();
        final Object other$measure = other.getMeasure();
        if (this$measure == null) {
            if (other$measure == null) {
                return true;
            }
        }
        else if (this$measure.equals(other$measure)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ItemQuantity;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getCount();
        final Object $measure = this.getMeasure();
        result = result * 59 + (($measure == null) ? 43 : $measure.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "ItemQuantity(count=" + this.getCount() + ", measure=" + this.getMeasure() + ")";
    }
}
