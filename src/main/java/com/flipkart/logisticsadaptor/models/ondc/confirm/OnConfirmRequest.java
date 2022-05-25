package com.flipkart.logisticsadaptor.models.ondc.confirm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flipkart.logisticsadaptor.models.ondc.common.Context;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnConfirmRequest {

    private Context context;

    private OnConfirmMessage message;
}
