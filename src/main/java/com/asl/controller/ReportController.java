package com.asl.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
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
import org.thymeleaf.util.StringUtils;

import com.asl.enums.ReportMenu;
import com.asl.model.RequestParameters;
import com.asl.service.PrintingService;

/**
 * @author Zubayer Ahamed
 * @since Dec 26, 2020
 */
@Controller
@RequestMapping("/report")
public class ReportController extends AbstractController {

	@Autowired private PrintingService printingService;

	@GetMapping("/{menuCode}")
	public String loadReportPage(@PathVariable String menuCode, Model model) {
		model.addAttribute("fieldsList", getReportFieldService(ReportMenu.valueOf(menuCode)).getReportFields());
		model.addAttribute("reportCode", menuCode.toLowerCase());
		return "pages/report/report";
	}

	@PostMapping("/print")
	public ResponseEntity<byte[]> print(RequestParameters params, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchMethodException, SecurityException {
		
		ReportMenu rm = ReportMenu.valueOf(params.getReportCode().toUpperCase());
		
		
		String message = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html"));
		headers.add("X-Content-Type-Options", "nosniff");

		// Parameters to send
		String reportName = "D:/ASL/cr-reports/" + rm.getReportFile();
		String reportTitle = "Test Report";
		boolean attachment = true;

		Map<String, String> reportParams = new HashMap<>();
		for(Map.Entry<String, String> m : rm.getParamMap().entrySet()) {
			String key = m.getKey();
			String fieldName = m.getValue();
			String methodName = "get" + StringUtils.capitalize(key);
			String method = RequestParameters.invokeGetter(params, key);
			reportParams.put(fieldName, "900010");
		}

		
//		reportParams.put("zid", "900010");
//		reportParams.put("category", "");
//		reportParams.put("item", "");
//		reportParams.put("status", "1");

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
			headers.add("content-disposition", "inline; filename=hello.pdf");
			headers.setContentType(new MediaType("application", "pdf"));
		}
		return new ResponseEntity<>(byt, headers, HttpStatus.OK);
	}
}
