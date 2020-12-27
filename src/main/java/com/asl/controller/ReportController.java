package com.asl.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asl.enums.ReportMenu;
import com.asl.model.RequestParameters;
import com.asl.service.PrintingService;

/**
 * @author Zubayer Ahamed
 * @since Dec 26, 2020
 */
@Controller
@RequestMapping("/report")
public class ReportController extends ASLAbstractController {

	@Autowired private PrintingService printingService;

	@GetMapping
	public String loadReportPage(Model model) {
		return "pages/report/reportlist";
	}

	@GetMapping("/{menuCode}")
	public String loadReportPage(@PathVariable String menuCode, Model model) {
		model.addAttribute("fieldsList", getReportFieldService(ReportMenu.valueOf(menuCode)).getReportFields());
		model.addAttribute("reportCode", menuCode.toLowerCase());
		model.addAttribute("reportName", ReportMenu.valueOf(menuCode).getDescription());
		return "pages/report/report";
	}

	@PostMapping("/print")
	public ResponseEntity<String> print(RequestParameters params, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchMethodException, SecurityException {
		ReportMenu rm = ReportMenu.valueOf(params.getReportCode().toUpperCase());

		String message = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html"));
		headers.add("X-Content-Type-Options", "nosniff");

		// Parameters to send
		String reportName = appConfig.getReportTemplatepath() + File.separator + rm.getReportFile();
		String reportTitle = "Test Report";
		boolean attachment = true;

		Map<String, String> reportParams = new HashMap<>();
		for(Map.Entry<String, String> m : rm.getParamMap().entrySet()) {
			String reportParamFieldName = m.getKey();
			String cristalReportParamName = m.getValue();
			String method = RequestParameters.invokeGetter(params, reportParamFieldName);
			reportParams.put(cristalReportParamName, method);
		}
		reportParams.put("category", "");
		reportParams.put("item", "");

		byte[] byt = null;
		BufferedInputStream in = printingService.getPDFBytes(reportName, reportTitle, attachment, reportParams);
		if (in == null) {
			message = "Can't generate PDF to print";
			byt = message.getBytes();
		} else {
			final byte[] data = new byte[1024];
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			while (in.read(data) > -1) {
				os.write(data);
			}

			byt = os.toByteArray();
			headers.add("content-disposition", "attachment; filename=hello.pdf");
			headers.setContentType(new MediaType("application", "pdf"));
		}

		String encodedString = Base64.getEncoder().encodeToString(byt);
		return new ResponseEntity<>(encodedString, headers, HttpStatus.OK);
	}
}
