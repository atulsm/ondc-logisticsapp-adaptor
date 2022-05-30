package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.internal.Geocode;

public interface ReverseGeocodeService {

     Integer getPincodeFromLatLong(Geocode geocode);
}
