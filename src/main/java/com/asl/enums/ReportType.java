package com.asl.enums;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
public enum ReportType {

	PDF("PDF","Pdf"), CSV("CSV","CSV"), DIRECT_PRINT("DP","Direct print");

	private String code;
	private String description;

	private ReportType(String code, String des) {
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
