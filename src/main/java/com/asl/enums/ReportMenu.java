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
	CSR(1, "CSR", "Category Sales Report", ReportParamMap.CSR, "opsalessupdet.rpt"),
	IWSS(1, "IWSS", "Item Wise Sales Summary", ReportParamMap.IWSS, "opsalessumitem.rpt"),
	SMWSS(1, "SMWSS", "Set Menu Wise Sales Summary", ReportParamMap.SMWSS, "opsalessumitemsermenu.rpt"),
	IWSST(1, "IWSST", "Item Wise Sales Summary (TP)", ReportParamMap.IWSST, "opsalessumitemtp.rpt"),
	IL(1, "IL","Item List", ReportParamMap.IL, "caitemlist.rpt"),
	IPH(1, "IPH","Item Price History", ReportParamMap.IPH, "caitemprice.rpt"),
	CRS(1, "CRS","Collection Report (Summary)", ReportParamMap.CRS, "opcollectsum.rpt"),
	CRD(1, "CRD", "Collection Report (Detail)", ReportParamMap.CRD, "opcollectdetail.rpt"),
	CCCD(1, "CCCD", "Credit Card Collection (Detail)", ReportParamMap.CCCD, "opposcardcollall.rpt"),
	SET(1, "SET","Sales (Eat in / Take Away)", ReportParamMap.SET, "opsaleinaway.rpt"),
	VR(1, "VR", "VAT Report (VAT-RATE-Wise)", ReportParamMap.VR, "opvatpackdaily.rpt"),
	SS(1, "SS", "Sync Status", ReportParamMap.SS, "casyncrpt.rpt"),
	DR(1, "DR", "Discount Report", ReportParamMap.DR, "opsummdis.rpt"),
	DSR(1, "DSR", "Delivery Service Report", ReportParamMap.DSR, "opsummsrv.rpt"),

	SRSV(2, "SRSV", "Sales Report (Summary)", ReportParamMap.SRSV, "opsumV.rpt"),
	SRDV(2, "SRDV", "Sales Report (Detail)", ReportParamMap.SRDV, "opdetailV.rpt"),
	IWSSV(2, "IWSSV", "Item Wise Sales Summary", ReportParamMap.IWSSV, "opsalessumitemV.rpt"),
	IPHV(2, "IPHV","Item Price History", ReportParamMap.IPHV, "caitemprice.rpt"),
	CRSV(2, "CRSV","Collection Report (Summary)", ReportParamMap.CRSV, "opcollectsumV.rpt"),
	CRDV(2, "CRDV", "Collection Report (Detail)", ReportParamMap.CRDV, "opcollectdetailV.rpt"),
	CCCDV(2, "CCCDV", "Credit Card Collection (Detail)", ReportParamMap.CCCDV, "opposcardcollallV.rpt"),
	SETV(2, "SETV","Sales (Eat in / Take Away)", ReportParamMap.SETV, "opsaleinawayV.rpt");

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
