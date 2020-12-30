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
	public static final Map<String, String> SRSV = new HashMap<>();
	public static final Map<String, String> SRD = new HashMap<>();
	public static final Map<String, String> SRDV = new HashMap<>();
	public static final Map<String, String> CBR = new HashMap<>();
	public static final Map<String, String> CSR = new HashMap<>();
	public static final Map<String, String> IWSS = new HashMap<>();
	public static final Map<String, String> IWSSV = new HashMap<>();
	public static final Map<String, String> SMWSS = new HashMap<>();
	public static final Map<String, String> IWSST = new HashMap<>();
	public static final Map<String, String> IL = new HashMap<>();
	public static final Map<String, String> IPH = new HashMap<>();
	public static final Map<String, String> IPHV = new HashMap<>();
	public static final Map<String, String> CRS = new HashMap<>();
	public static final Map<String, String> CRSV = new HashMap<>();
	public static final Map<String, String> CRD = new HashMap<>();
	public static final Map<String, String> CRDV = new HashMap<>();
	public static final Map<String, String> CCCD = new HashMap<>();
	public static final Map<String, String> CCCDV = new HashMap<>();
	public static final Map<String, String> SET = new HashMap<>();
	public static final Map<String, String> SETV = new HashMap<>();
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

		CSR.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		CSR.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		CSR.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		CSR.put("param4", "div|" + ReportParamDataType.STRING.name());
		CSR.put("param5", "citem|" + ReportParamDataType.STRING.name());
		CSR.put("param6", "item|" + ReportParamDataType.STRING.name());
		CSR.put("param7", "reptype|" + ReportParamDataType.STRING.name());

		IWSS.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		IWSS.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		IWSS.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		IWSS.put("param4", "div|" + ReportParamDataType.STRING.name());
		IWSS.put("param5", "item|" + ReportParamDataType.STRING.name());

		SMWSS.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		SMWSS.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		SMWSS.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		SMWSS.put("param4", "div|" + ReportParamDataType.STRING.name());
		SMWSS.put("param5", "item|" + ReportParamDataType.STRING.name());

		IWSST.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		IWSST.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		IWSST.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		IWSST.put("param4", "div|" + ReportParamDataType.STRING.name());
		IWSST.put("param5", "item|" + ReportParamDataType.STRING.name());

		IL.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		IL.put("param2", "item|" + ReportParamDataType.STRING.name());
		IL.put("param3", "category|" + ReportParamDataType.STRING.name());
		IL.put("param4", "status|" + ReportParamDataType.STRING.name());

		IPH.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		IPH.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		IPH.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		IPH.put("param4", "item|" + ReportParamDataType.STRING.name());

		CRS.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		CRS.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		CRS.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		CRS.put("param4", "terminal|" + ReportParamDataType.STRING.name());

		CRD.put("param1", "@zid|" + ReportParamDataType.INTEGER.name());
		CRD.put("param2", "@puser|" + ReportParamDataType.STRING.name());
		CRD.put("param3", "@pfterminal|" + ReportParamDataType.STRING.name());
		CRD.put("param4", "@ptterminal|" + ReportParamDataType.STRING.name());
		CRD.put("param5", "@fdate|" + ReportParamDataType.DATESTRING.name());
		CRD.put("param6", "@tdate|" + ReportParamDataType.DATESTRING.name());

		CCCD.put("param1", "@zid|" + ReportParamDataType.INTEGER.name());
		CCCD.put("param2", "@user|" + ReportParamDataType.STRING.name());
		CCCD.put("param3", "@terminal|" + ReportParamDataType.STRING.name());
		CCCD.put("param4", "@date|" + ReportParamDataType.DATESTRING.name());

		SET.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		SET.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		SET.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		SET.put("param4", "terminal|" + ReportParamDataType.STRING.name());
		SET.put("param5", "pack|" + ReportParamDataType.STRING.name());
		SET.put("param6", "item|" + ReportParamDataType.STRING.name());

		VR.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		VR.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		VR.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		VR.put("param4", "div|" + ReportParamDataType.STRING.name());
		VR.put("param5", "shop|" + ReportParamDataType.STRING.name());

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

		SRSV.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		SRSV.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		SRSV.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		SRSV.put("param4", "terminal|" + ReportParamDataType.STRING.name());
		SRSV.put("param5", "rpttype|" + ReportParamDataType.STRING.name());

		SRDV.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		SRDV.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		SRDV.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		SRDV.put("param4", "terminal|" + ReportParamDataType.STRING.name());

		IWSSV.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		IWSSV.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		IWSSV.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		IWSSV.put("param4", "item|" + ReportParamDataType.STRING.name());

		IPHV.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		IPHV.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		IPHV.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		IPHV.put("param4", "item|" + ReportParamDataType.STRING.name());

		CRSV.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		CRSV.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		CRSV.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		CRSV.put("param4", "terminal|" + ReportParamDataType.STRING.name());

		CRDV.put("param1", "@zid|" + ReportParamDataType.INTEGER.name());
		CRDV.put("param2", "@puser|" + ReportParamDataType.STRING.name());
		CRDV.put("param3", "@pfterminal|" + ReportParamDataType.STRING.name());
		CRDV.put("param4", "@ptterminal|" + ReportParamDataType.STRING.name());
		CRDV.put("param5", "@fdate|" + ReportParamDataType.DATESTRING.name());
		CRDV.put("param6", "@tdate|" + ReportParamDataType.DATESTRING.name());

		CCCDV.put("param1", "@zid|" + ReportParamDataType.INTEGER.name());
		CCCDV.put("param2", "@user|" + ReportParamDataType.STRING.name());
		CCCDV.put("param3", "@terminal|" + ReportParamDataType.STRING.name());
		CCCDV.put("param4", "@date|" + ReportParamDataType.DATESTRING.name());

		SETV.put("param1", "zid|" + ReportParamDataType.INTEGER.name());
		SETV.put("param2", "fdate|" + ReportParamDataType.DATE.name());
		SETV.put("param3", "tdate|" + ReportParamDataType.DATE.name());
		SETV.put("param4", "terminal|" + ReportParamDataType.STRING.name());
		SETV.put("param5", "pack|" + ReportParamDataType.STRING.name());
		SETV.put("param6", "item|" + ReportParamDataType.STRING.name());
	}
}
