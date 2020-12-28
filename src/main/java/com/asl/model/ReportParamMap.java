package com.asl.model;

import java.util.HashMap;
import java.util.Map;

import com.asl.enums.ReportParamDataType;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
public class ReportParamMap {

	public static final Map<String, String> SRS = new HashMap<>();
	public static final Map<String, String> SRD = new HashMap<>();
	public static final Map<String, String> CBR = new HashMap<>();
	public static final Map<String, String> CSR = new HashMap<>();
	public static final Map<String, String> IWSS = new HashMap<>();
	public static final Map<String, String> SMWSS = new HashMap<>();
	public static final Map<String, String> IWSST = new HashMap<>();
	public static final Map<String, String> IL = new HashMap<>();
	public static final Map<String, String> IPH = new HashMap<>();
	public static final Map<String, String> CRS = new HashMap<>();
	public static final Map<String, String> CRD = new HashMap<>();
	public static final Map<String, String> CCCD = new HashMap<>();
	public static final Map<String, String> SET = new HashMap<>();
	public static final Map<String, String> VR = new HashMap<>();
	public static final Map<String, String> SS = new HashMap<>();
	public static final Map<String, String> DR = new HashMap<>();
	public static final Map<String, String> DSR = new HashMap<>();

	static {
		SRS.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		SRS.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		SRS.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		SRS.put("param4", "div|" + ReportParamDataType.STRING.name());
		SRS.put("param5", "terminal|" + ReportParamDataType.STRING.name());
		SRS.put("param6", "rpttype|" + ReportParamDataType.STRING.name());

		SRD.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		SRD.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		SRD.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		SRD.put("param4", "div|" + ReportParamDataType.STRING.name());
		SRD.put("param5", "terminal|" + ReportParamDataType.STRING.name());

		CBR.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		CBR.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		CBR.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		CBR.put("param4", "terminal|" + ReportParamDataType.STRING.name());

		CRS.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		CRS.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		CRS.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		CRS.put("param4", "terminal|" + ReportParamDataType.STRING.name());

		SS.put("param1", "zid|" + ReportParamDataType.INTEGER.name());

		DR.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		DR.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		DR.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		DR.put("param4", "div|" + ReportParamDataType.STRING.name());
		DR.put("param5", "terminal|" + ReportParamDataType.STRING.name());
		DR.put("param6", "rpttype|" + ReportParamDataType.STRING.name());

		DSR.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		DSR.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		DSR.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		DSR.put("param4", "div|" + ReportParamDataType.STRING.name());
		DSR.put("param5", "terminal|" + ReportParamDataType.STRING.name());
		DSR.put("param6", "rpttype|" + ReportParamDataType.STRING.name());
	}
}
