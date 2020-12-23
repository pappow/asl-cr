/**
 * 
 */
package com.asl.controller;

import java.io.IOException;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asl.util.ZabCRViewer;
import com.crystaldecisions.sdk.occa.report.application.OpenReportOptions;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKExceptionBase;

/**
 * @author zubayer
 *
 */
@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String loadHomePage(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			printBill(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

	public void printBill(HttpServletResponse response) throws IOException {

		String reportName = "D:/ASL/caitemlist.rpt";

		ReportClientDocument clientDoc = new ReportClientDocument();

		try {
			clientDoc.setReportAppServer(ReportClientDocument.inprocConnectionString);

			// Open report
			// close for checking
			clientDoc.open(reportName, OpenReportOptions._openAsReadOnly);

			// ****** BEGIN SET RUNTIME DATABASE CREDENTIALS ****************

			ZabCRViewer.changeDataSource(clientDoc);

			// logon to database
			ZabCRViewer.logonDataSource(clientDoc);

			ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "zid", 900010);
			ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "category", "");
			ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "item", "");
			ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "status", "1");
			PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//			ZabCRViewer.printToServer(clientDoc, service.getName());
//			ZabCRViewer.exportPDF(clientDoc, true);
			ZabCRViewer.exportPDF(clientDoc, response, "ztitle", true);

		} catch (ReportSDKExceptionBase e) {
			e.printStackTrace();
		}

	}
}
