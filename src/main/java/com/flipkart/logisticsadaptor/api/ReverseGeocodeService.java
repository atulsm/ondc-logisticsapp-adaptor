package com.flipkart.logisticsadaptor.api;

import com.flipkart.logisticsadaptor.models.Geocode;

public interface ReverseGeocodeService {

     Integer getPincodeFromLatLong(Geocode geocode);
}
