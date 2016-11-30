package com.quantil.global;

public enum TestDataKey {

	DOMAIN_ID("domainId"),
	DOMAIN("domainObj"),
	DOMAIN_LIST("domainListObj"), 
	DATE_FROM("dateFrom"),
	DATE_TO("dateTo"), 
	RANGE_START("rangeStart"), 
	RANGE_END("rangeEnd"),
	TIMEZONE("timezone"), 
	REPORT_TYPE("reportType"),
	SERVICE_TYPE("serviceType"),
	REPORT_DATA("reportData"),
	DOMAIN_NAME("domainName"),
	INTERVAL("interval"),
	TRANSPORT_TYPE("transportType"),
	TRANSPORT_ID("transportId");

	private String value;
	
	TestDataKey(String value) {
		
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		
		return this.value;
	}
}
