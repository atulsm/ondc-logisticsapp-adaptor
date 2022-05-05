package com.flipkart.logisticsadaptor.models.ekart;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Connections {
    Map<String , SLAValue> serviceTypeToSLA;
}
