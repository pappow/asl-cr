package com.asl.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
public class ReportParamMap {

	public static final Map<String, String> SRS = new HashMap<>();
	public static final Map<String, String> SRD = new HashMap<>();
	public static final Map<String, String> CBR = new HashMap<>();
	public static final Map<String, String> CSR = new HashMap<>();
	public static final Map<String, String> IWSST = new HashMap<>();
	public static final Map<String, String> IL = new HashMap<>();
	public static final Map<String, String> IPH = new HashMap<>();
	public static final Map<String, String> CRS = new HashMap<>();
	public static final Map<String, String> CRD = new HashMap<>();
	public static final Map<String, String> CCCD = new HashMap<>();
	public static final Map<String, String> SALES = new HashMap<>();
	public static final Map<String, String> VR = new HashMap<>();
	public static final Map<String, String> SS = new HashMap<>();
	public static final Map<String, String> DR = new HashMap<>();
	public static final Map<String, String> DSR = new HashMap<>();

	static {
		SRS.put("status", "status");
		SRS.put("param0", "zid");
	}
}
