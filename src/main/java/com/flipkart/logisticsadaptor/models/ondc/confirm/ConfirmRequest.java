package com.flipkart.logisticsadaptor.models.ondc.confirm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flipkart.logisticsadaptor.models.ondc.common.Context;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmRequest {
    private Context context;

    private ConfirmMessage message;
}
