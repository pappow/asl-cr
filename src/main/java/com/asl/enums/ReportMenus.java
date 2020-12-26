package com.asl.enums;

/**
 * @author Zubayer Ahamed
 * @since Dec 26, 2020
 */
public enum ReportMenus {

	SALES_REPORT_SUMMERY("SRS", "Sales Report (Summary)"),
	SALES_REPORT_DETAIL("SRD", "Sales Report (Detail)"),
	CANCEL_BILL_REPORT("CBR", "Cancel Bill Report"),
	CATEGORY_SALES_REPORT("CSR", "Category Sales Report"),
	ITEM_WISE_SALES_SUMMARY_TP("IWSST", "Item Wise Sales Summary(TP)"),
	ITEM_LIST("IL","Item List"),
	ITEM_PRICE_HISTORY("IPH","Item Price History"),
	COLLECTION_REPORT_SUMMARY("CRS","Collection Report (Summary)"),
	COLLECTION_REPORT_DETAIL("CRD", "Collection Report (Detail)"),
	CREDIT_CARD_COLLECTION_DETAIL("CCCD", "Credit Card Collection (Detail)"),
	SALES("SALES","Sales (Eat in / Take Away)"),
	VAT_REPORT("VR", "VAT Report (VAT-RATE-Wise)"),
	SYNC_STATUS("SS", "Sync Status"),
	DISCOUNT_REPORT("DR", "Discount Report"),
	DELIVERY_SERVICE_REPORT("DSR", "Delivery Service Report");

	private String code;
	private String description;

	private ReportMenus(String code, String des) {
		this.code = code;
		this.description = des;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}
