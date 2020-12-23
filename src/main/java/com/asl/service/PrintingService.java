package com.asl.service;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import com.asl.model.DBConnectInfo;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;

/**
 * @author Zubayer Ahamed
 *
 */
public interface PrintingService {

	public ByteArrayOutputStream getPDFBytes(String reportName, String reportTitle, boolean attachment, Map<String, String> reportParams);

	public void logonDataSource(ReportClientDocument clientDoc, DBConnectInfo connectionInfo);
}
