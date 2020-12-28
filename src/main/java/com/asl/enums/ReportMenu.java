package com.asl.enums;

import java.util.Map;

import com.asl.model.ReportParamMap;

/**
 * @author Zubayer Ahamed
 * @since Dec 26, 2020
 */
public enum ReportMenu {

	SRS(1, "SRS", "Sales Report (Summary)", ReportParamMap.SRS, "opsumm.rpt"),
	SRD(1, "SRD", "Sales Report (Detail)", ReportParamMap.SRD, "opdetail.rpt"),
	CBR(1, "CBR", "Cancel Bill Report", ReportParamMap.CBR, "opcanceldetail.rpt"),
//	CSR("CSR", "Category Sales Report", ReportParamMap.CSR, ""),
//	IWSST("IWSST", "Item Wise Sales Summary(TP)", ReportParamMap.IWSST, ""),
//	IL("IL","Item List", ReportParamMap.IL, ""),
//	IPH("IPH","Item Price History", ReportParamMap.IPH, ""),
	CRS(1, "CRS","Collection Report (Summary)", ReportParamMap.CRS, "opcollectsum.rpt"),
//	CRD("CRD", "Collection Report (Detail)", ReportParamMap.CRD, ""),
//	CCCD("CCCD", "Credit Card Collection (Detail)", ReportParamMap.CCCD, ""),
//	SALES("SALES","Sales (Eat in / Take Away)", ReportParamMap.SALES, ""),
//	VR("VR", "VAT Report (VAT-RATE-Wise)", ReportParamMap.VR, ""),
	SS(1, "SS", "Sync Status", ReportParamMap.SS, "casyncrpt.rpt"),
	DR(1, "DR", "Discount Report", ReportParamMap.DR, "opsummdis.rpt"),
	DSR(1, "DSR", "Delivery Service Report", ReportParamMap.DSR, "opsummsrv.rpt"),

	SRSV(2, "SRS", "Sales Report (Summary)", ReportParamMap.SRS, "opsumV.rpt"),
	SRDV(2, "SRD", "Sales Report (Detail)", ReportParamMap.SRD, "opdetailV.rpt"),
	CRSV(2, "CRS","Collection Report (Summary)", ReportParamMap.CRS, "opcollectsumV.rpt");

	private int group;
	private String code;
	private String description;
	private Map<String, String> paramMap;
	private String reportFile;

	private ReportMenu(int group, String code, String des, Map<String, String> paramMap, String reportFile) {
		this.group = group;
		this.code = code;
		this.description = des;
		this.paramMap = paramMap;
		this.reportFile = reportFile;
	}

	public int getGroup() {
		return this.group;
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
