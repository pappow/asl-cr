package com.asl.enums;

import java.util.Map;

import com.asl.model.ReportParamMap;

/**
 * @author Zubayer Ahamed
 * @since Dec 26, 2020
 */
public enum ReportMenu {

	SRS("SRS", "Sales Report (Summary)", ReportParamMap.SRS, "caitemlist.rpt"),
	SRD("SRD", "Sales Report (Detail)", ReportParamMap.SRD, ""),
	CBR("CBR", "Cancel Bill Report", ReportParamMap.CBR, ""),
	CSR("CSR", "Category Sales Report", ReportParamMap.CSR, ""),
	IWSST("IWSST", "Item Wise Sales Summary(TP)", ReportParamMap.IWSST, ""),
	IL("IL","Item List", ReportParamMap.IL, ""),
	IPH("IPH","Item Price History", ReportParamMap.IPH, ""),
	CRS("CRS","Collection Report (Summary)", ReportParamMap.CRS, ""),
	CRD("CRD", "Collection Report (Detail)", ReportParamMap.CRD, ""),
	CCCD("CCCD", "Credit Card Collection (Detail)", ReportParamMap.CCCD, ""),
	SALES("SALES","Sales (Eat in / Take Away)", ReportParamMap.SALES, ""),
	VR("VR", "VAT Report (VAT-RATE-Wise)", ReportParamMap.VR, ""),
	SS("SS", "Sync Status", ReportParamMap.SS, ""),
	DR("DR", "Discount Report", ReportParamMap.DR, ""),
	DSR("DSR", "Delivery Service Report", ReportParamMap.DSR, "");

	private String code;
	private String description;
	private Map<String, String> paramMap;
	private String reportFile;

	private ReportMenu(String code, String des, Map<String, String> paramMap, String reportFile) {
		this.code = code;
		this.description = des;
		this.paramMap = paramMap;
		this.reportFile = reportFile;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public Map<String, String> getParamMap() {
		return this.paramMap;
	}

	public String getReportFile() {
		return this.reportFile;
	}
}
