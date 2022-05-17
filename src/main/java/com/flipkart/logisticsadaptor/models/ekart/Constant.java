package com.flipkart.logisticsadaptor.models.ekart;

public class Constant {
	public final static String DEFAULT_PASSWORD = "password";
	public final static int EXPIRATION_TIME_HOURS = 12;
	public final static String APP_ID = "EKL-Durin";
	public final static String SHIPMENT = "shipment";
	public final static String REPLACEMENT = "replacement";
	public final static String OUTGOING = "outgoing";
	public final static String TRACKING_ID = "vendor_tracking_id";
	public final static String REQUEST_ACCEPTED = "request_accepted";
	public final static String REQUEST_REJECTED = "request_rejected";
	public final static String VENDOR_TRACKING_ID = "vendor_tracking_id";
	public final static String X_CALLBACK_CODES_HEADER = "X_CALLBACK_CODES";
	public final static String CALLBACK_URL = "/v2/shipments/callback";
	public final static String LARGE_FULFILL_ENDPOINT = "/v2/shipments/fulfill_large";
	public final static String X_RESTBUS_DESTINATION_RESPONSE_STATUS = "X_RESTBUS_DESTINATION_RESPONSE_STATUS";
	public final static String X_CALLBACK_CODES = "[{\"from\": 200, \"to\": 299}, {\"from\": 400, \"to\": 499}]";
	public final static String X_CREATE_CALLBACK_CODES = "[{\"from\": 200, \"to\": 299}]";
	public final static String SHIPPING_TRACK_ENDPOINT = "/kaveri_shipments/track";
	public final static String SHIPPING_GET_SHIPMENT_DETAILS_ENDPOINT = "/kaveri_shipments/get_shipment_details";
	public final static String X_PROVIDER_ID = "X_PROVIDER_ID";
	public final static String X_PROVIDER_ID_VALUE = "EKART";
	public final static String FACILITY_CAPABILITY = "WH_MH";
	public final static String FKL_FACILITY_CAPABILITY = "FKL_MH";
	public final static String EKART_TENANT = "ekart";
	public final static String EKART_LARGE_TENANT = "ekart_large";

	public final static int HTTP_STATUS_RATE_LIMIT_EXCEEDED = 429;

	public class LPEConstant{
		public final static String LPE_SERVICE_PROFILE = "FKMP_NONFBF";
		public final static String LPE_SHIPMENT_SIZE = "Small";
		public final static String LPE_VERTICAL = "Others";
		public final static String LPE_PREPAID = "prepaid";
		public final static String LPE_COD = "cod";
		public final static String LPE_FORWARD = "Delivery";
		public final static String LPE_TIMEZONE = "+05:30";
		public final static String LPE_RVP = "rvp";
		public final static String LPE_VERTICAL_LARGE = "television";
		public final static String DANGEROUS = "DANGEROUS";
		public final static String FRAGILE = "FRAGILE";
		public final static String FORWARD = "-FWD";
		public final static String REVERSE = "-RVP";
	}

    public enum EklWalletVendorList{
        CDM_YESBANK
    }

    public class AssignorConstant {
		public final static String VALIDATE_ID_ENDPOINT = "/vendors/#vendor_tracking_id/validate_tracking_id";
		public final static String CREATE_ID_ENDPOINT = "/vendors/#vendor_tracking_id/validate_or_generate?merchant_code=#merchant_code";
		public final static String GENERATE_SHIPMENT_PAYMENT_LINK_ENDPOINT = "/shipments/generate_payment_link";
		public final static String MERCHANT_CODE_PARAM = "merchant_code";
		public final static String VALIDATE_TRACKING_ID_ENDPOINT = "/vendors/externalization/validate_tracking_id";
		public final static String GET_LABEL_INFO_ENDPOINT = "/tracking_id/externalization/get_label_info";
	}

	public class GeoCodeService {
		public final static String COUNTRY = "India";
		public final static String GEOCODEREQUEST = "geocodeRequest";
	}

	public enum AuthMethods{
		BASIC, BEARER
	}

	public enum NetworkClients {
		MYN, FLIPKART
	}
}
