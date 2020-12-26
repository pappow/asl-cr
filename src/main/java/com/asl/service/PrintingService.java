package com.asl.service;

import java.io.BufferedInputStream;
import java.util.Map;

import com.asl.model.DBConfig;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;

/**
 * @author Zubayer Ahamed
 *
 */
public interface PrintingService {

	public BufferedInputStream getPDFBytes(String reportName, String reportTitle, boolean attachment, Map<String, String> reportParams);

	public void changeDataSource(ReportClientDocument clientDoc, String reportName, String tableName, DBConfig dbConfig) throws ReportSDKException;
	public void logonDataSource(ReportClientDocument clientDoc, DBConfig dbConfig) throws ReportSDKException;
	public void addDiscreteParameterValue(ReportClientDocument clientDoc, String reportName, String parameterName, Object newValue) throws ReportSDKException;
}
