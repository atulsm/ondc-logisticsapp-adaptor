package com.flipkart.logisticsadaptor.models.ondc.search;


import com.flipkart.logisticsadaptor.models.ondc.common.Intent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchMessage
{
    private Intent intent;
    
    public Intent getIntent() {
        return this.intent;
    }
    
    public void setIntent(final Intent intent) {
        this.intent = intent;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SearchMessage)) {
            return false;
        }
        final SearchMessage other = (SearchMessage)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$intent = this.getIntent();
        final Object other$intent = other.getIntent();
        if (this$intent == null) {
            if (other$intent == null) {
                return true;
            }
        }
        else if (this$intent.equals(other$intent)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof SearchMessage;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $intent = this.getIntent();
        result = result * 59 + (($intent == null) ? 43 : $intent.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "SearchMessage(intent=" + this.getIntent() + ")";
    }
}
