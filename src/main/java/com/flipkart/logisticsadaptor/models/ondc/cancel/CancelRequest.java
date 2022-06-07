// 
// Decompiled by Procyon v0.5.36
// 

package com.flipkart.logisticsadaptor.models.ondc.cancel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flipkart.logisticsadaptor.commons.models.internal.Merchant;
import com.flipkart.logisticsadaptor.models.ondc.common.Context;
import com.google.inject.name.Named;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CancelRequest
{
    private Context context;
    private CancelMessage message;

    @JsonIgnore
    private Merchant merchant;
    
    public Context getContext() {
        return this.context;
    }
    
    public CancelMessage getMessage() {
        return this.message;
    }
    
    public void setContext(final Context context) {
        this.context = context;
    }
    
    public void setMessage(final CancelMessage message) {
        this.message = message;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CancelRequest)) {
            return false;
        }
        final CancelRequest other = (CancelRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$context = this.getContext();
        final Object other$context = other.getContext();
        Label_0065: {
            if (this$context == null) {
                if (other$context == null) {
                    break Label_0065;
                }
            }
            else if (this$context.equals(other$context)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null) {
            if (other$message == null) {
                return true;
            }
        }
        else if (this$message.equals(other$message)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof CancelRequest;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $context = this.getContext();
        result = result * 59 + (($context == null) ? 43 : $context.hashCode());
        final Object $message = this.getMessage();
        result = result * 59 + (($message == null) ? 43 : $message.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "CancelRequest(context=" + this.getContext() + ", message=" + this.getMessage() + ")";
    }
}
