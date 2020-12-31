package com.asl.service.impl;

import java.io.BufferedInputStream;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.asl.model.DBConfig;
import com.asl.service.PrintingService;
import com.crystaldecisions.sdk.occa.report.application.DataDefController;
import com.crystaldecisions.sdk.occa.report.application.OpenReportOptions;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.data.FieldDisplayNameType;
import com.crystaldecisions.sdk.occa.report.data.IConnectionInfo;
import com.crystaldecisions.sdk.occa.report.data.ITable;
import com.crystaldecisions.sdk.occa.report.data.IValue;
import com.crystaldecisions.sdk.occa.report.data.ParameterField;
import com.crystaldecisions.sdk.occa.report.data.ParameterFieldDiscreteValue;
import com.crystaldecisions.sdk.occa.report.data.Tables;
import com.crystaldecisions.sdk.occa.report.data.Values;
import com.crystaldecisions.sdk.occa.report.exportoptions.ExportOptions;
import com.crystaldecisions.sdk.occa.report.exportoptions.PDFExportFormatOptions;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;
import com.crystaldecisions.sdk.occa.report.lib.IStrings;
import com.crystaldecisions.sdk.occa.report.lib.PropertyBag;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 *
 */
@Slf4j
@Service
public class PrintingServiceImpl implements PrintingService {

	private static final String TRUSTED_CONNECTION = "false";
	private static final String SERVER_TYPE = "JDBC (JNDI)";
	private static final String USE_JDBC = "true";
	private static final String DATABASE_DLL = "crdb_jdbc.dll";

	@Autowired private Environment env;

	@Override
	public BufferedInputStream getPDFBytes(String reportName, String reportTitle, boolean attachment, Map<String, Object> reportParams) {
		ReportClientDocument clientDoc = new ReportClientDocument();
		try {
			clientDoc.setReportAppServer(ReportClientDocument.inprocConnectionString);
			clientDoc.open(reportName, OpenReportOptions._openAsReadOnly);

			DBConfig dbConfig = new DBConfig();
			dbConfig.setConnectionURL(env.getProperty("spring.datasource.url"));
			dbConfig.setDriverName(env.getProperty("spring.datasource.driver-class-name"));
			dbConfig.setJndiName(env.getProperty("JNDIName"));
			dbConfig.setUsername(env.getProperty("spring.datasource.username"));
			dbConfig.setPassword(env.getProperty("spring.datasource.password"));
			changeDataSource(clientDoc, null, null, dbConfig);
			logonDataSource(clientDoc, dbConfig);

			for(Map.Entry<String, Object> param : reportParams.entrySet()) {
				addDiscreteParameterValue(clientDoc, "", param.getKey(), param.getValue());
			}

			PDFExportFormatOptions pdfOptions = new PDFExportFormatOptions();
			ExportOptions exportOptions = new ExportOptions();
			exportOptions.setExportFormatType(ReportExportFormat.PDF);
			exportOptions.setFormatOptions(pdfOptions);

			return new BufferedInputStream(clientDoc.getPrintOutputController()
						.export((com.crystaldecisions.sdk.occa.report.exportoptions.IExportOptions) exportOptions));

		} catch (ReportSDKException e) {
			log.error("Error is : {}, {}", e.getMessage(), e);
			return null;
		}
	}

	

	@Override
	public void changeDataSource(ReportClientDocument clientDoc, String reportName, String tableName, DBConfig dbConfig) throws ReportSDKException {
		PropertyBag propertyBag = null;
		IConnectionInfo connectionInfo = null;
		ITable origTable = null;
		ITable newTable = null;

		if (reportName == null || reportName.equals("")) {
			final Tables tables = clientDoc.getDatabaseController().getDatabase().getTables();
			for (int i = 0; i < tables.size(); ++i) {
				origTable = tables.getTable(i);
				if (tableName == null || origTable.getName().equals(tableName)) {
					newTable = (ITable) origTable.clone(true);
					newTable.setQualifiedName(origTable.getAlias());
					connectionInfo = newTable.getConnectionInfo();
					propertyBag = new PropertyBag();
					propertyBag.put((Object) "Trusted_Connection", (Object) TRUSTED_CONNECTION);
					propertyBag.put((Object) "Server Type", (Object) SERVER_TYPE);
					propertyBag.put((Object) "Use JDBC", (Object) USE_JDBC);
					propertyBag.put((Object) "Database DLL", (Object) DATABASE_DLL);
					propertyBag.put((Object) "JNDI Datasource Name", (Object) dbConfig.getJndiName());
					propertyBag.put((Object) "Connection URL", (Object) dbConfig.getConnectionURL());
					propertyBag.put((Object) "Database Class Name", (Object) dbConfig.getDriverName());
					connectionInfo.setAttributes(propertyBag);
					connectionInfo.setUserName(dbConfig.getUsername());
					connectionInfo.setPassword(dbConfig.getPassword());
					clientDoc.getDatabaseController().setTableLocation(origTable, newTable);
				}
			}
		}
		if (reportName == null || !reportName.equals("")) {
			final IStrings subNames = clientDoc.getSubreportController().getSubreportNames();
			for (int subNum = 0; subNum < subNames.size(); ++subNum) {
				final Tables tables2 = clientDoc.getSubreportController().getSubreport(subNames.getString(subNum))
						.getDatabaseController().getDatabase().getTables();
				for (int j = 0; j < tables2.size(); ++j) {
					origTable = tables2.getTable(j);
					if (tableName == null || origTable.getName().equals(tableName)) {
						newTable = (ITable) origTable.clone(true);
						newTable.setQualifiedName(origTable.getAlias());
						connectionInfo = newTable.getConnectionInfo();
						propertyBag = new PropertyBag();
						propertyBag.put((Object) "Trusted_Connection", (Object) TRUSTED_CONNECTION);
						propertyBag.put((Object) "Server Type", (Object) SERVER_TYPE);
						propertyBag.put((Object) "Use JDBC", (Object) USE_JDBC);
						propertyBag.put((Object) "Database DLL", (Object) DATABASE_DLL);
						propertyBag.put((Object) "JNDI Datasource Name", (Object) dbConfig.getJndiName());
						propertyBag.put((Object) "Connection URL", (Object) dbConfig.getConnectionURL());
						propertyBag.put((Object) "Database Class Name", (Object) dbConfig.getDriverName());
						connectionInfo.setAttributes(propertyBag);
						connectionInfo.setUserName(dbConfig.getUsername());
						connectionInfo.setPassword(dbConfig.getPassword());
						clientDoc.getSubreportController().getSubreport(subNames.getString(subNum))
								.getDatabaseController().setTableLocation(origTable, newTable);
					}
				}
			}
		}

	}

	@Override
	public void logonDataSource(ReportClientDocument clientDoc, DBConfig dbConfig) throws ReportSDKException {
		clientDoc.getDatabaseController().logon(dbConfig.getUsername(), dbConfig.getPassword());
	}

	@Override
	public void addDiscreteParameterValue(ReportClientDocument clientDoc, String reportName, String parameterName, Object newValue) throws ReportSDKException {
		DataDefController dataDefController = clientDoc.getDataDefController();
		if (StringUtils.isNotBlank(reportName)) {
			dataDefController = clientDoc.getSubreportController().getSubreport(reportName).getDataDefController();
		}

		final ParameterFieldDiscreteValue newDiscValue = new ParameterFieldDiscreteValue();
		newDiscValue.setValue(newValue);
		final ParameterField paramField = (ParameterField) dataDefController.getDataDefinition().getParameterFields().findField(parameterName, FieldDisplayNameType.fieldName, Locale.getDefault());
		final boolean multiValue = paramField.getAllowMultiValue();
		if (multiValue) {
			final Values newVals = (Values) paramField.getCurrentValues().clone(true);
			newVals.add((IValue) newDiscValue);
			clientDoc.getDataDefController().getParameterFieldController().setCurrentValue(reportName, parameterName, (Object) newVals);
		} else {
			clientDoc.getDataDefController().getParameterFieldController().setCurrentValue(reportName, parameterName, newValue);
		}
	}


}
