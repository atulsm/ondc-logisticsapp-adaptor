package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.commons.models.Geocode;

public interface ReverseGeocodeService {

     Integer getPincodeFromLatLong(Geocode geocode);
}
