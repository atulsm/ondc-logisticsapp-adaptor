package com.flipkart.logisticsadaptor.models.ondc.confirm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flipkart.logisticsadaptor.models.ondc.common.Order;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnConfirmMessage {

    private Order order;
}
