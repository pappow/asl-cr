package com.asl.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.asl.model.DBConnectInfo;
import com.asl.service.PrintingService;
import com.crystaldecisions.sdk.occa.report.application.OpenReportOptions;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.data.IConnectionInfo;
import com.crystaldecisions.sdk.occa.report.data.ITable;
import com.crystaldecisions.sdk.occa.report.lib.PropertyBag;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zubayer
 *
 */
@Slf4j
@Service
public class PrintingServiceImpl implements PrintingService {

	private static final String TRUSTED_CONNECTION = "false";
	private static final String SERVER_TYPE = "JDBC (JNDI)";
	private static final String USE_JDBC = "true";
	private static final String DATABASE_DLL = "crdb_jdbc.dll";

	@Override
	public ByteArrayOutputStream getPDFBytes(String reportName, String reportTitle, boolean attachment, Map<String, String> reportParams) {
		ReportClientDocument clientDoc = new ReportClientDocument();
		try {
			clientDoc.setReportAppServer(ReportClientDocument.inprocConnectionString);
			clientDoc.open(reportName, OpenReportOptions._openAsReadOnly);
			
		} catch (ReportSDKException e) {
			log.error("Error is : {}, {}", e.getMessage(), e);
		}
		
		return null;
	}

	@Override
	public void logonDataSource(ReportClientDocument clientDoc, DBConnectInfo dbConnectionInfo) {

		PropertyBag propertyBag = null;
		IConnectionInfo connectionInfo = null;
		ITable origTable = null;
		ITable newTable = null;

		
		
	}



	
}
