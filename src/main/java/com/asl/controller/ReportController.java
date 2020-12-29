package com.asl.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
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
import com.asl.enums.ReportParamDataType;
import com.asl.model.RequestParameters;
import com.asl.service.PrintingService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 * @since Dec 26, 2020
 */
@Slf4j
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

		Map<String, Object> reportParams = new HashMap<>();
		for(Map.Entry<String, String> m : rm.getParamMap().entrySet()) {
			String reportParamFieldName = m.getKey();
			String[] arr = m.getValue().split("\\|");
			String cristalReportParamName = arr[0];
			ReportParamDataType paramType = ReportParamDataType.valueOf(arr[1]);
			Object method = RequestParameters.invokeGetter(params, reportParamFieldName);
			convertObjectAndPutIntoMap(cristalReportParamName, paramType, method, reportParams);
		}

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

	private void convertObjectAndPutIntoMap(String paramName, ReportParamDataType paramType, Object method, Map<String, Object> reportParams) {
		SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MMM-yyyy");
		switch (paramType) {
			case DATE:
				try {
					reportParams.put(paramName, sdf.parseObject((String) method));
				} catch (ParseException e) {
					log.error(ERROR, e.getMessage(), e);
				}
				break;
			case DATESTRING:
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date = (Date) sdf.parseObject((String) method);
					System.out.println(sdf2.format(date));
					reportParams.put(paramName, sdf2.format(date));
				} catch (ParseException e) {
					log.error(ERROR, e.getMessage(), e);
				}
				break;
			default:
				reportParams.put(paramName, method);
				break;
		}
	}
}
