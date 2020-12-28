package com.asl.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asl.service.PrintingService;

@Controller
@RequestMapping("/print")
public class PrintingController {

	@Autowired
	private PrintingService printingService;

	@GetMapping
	public ResponseEntity<byte[]> print(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html"));
		headers.add("X-Content-Type-Options", "nosniff");

		// Parameters to send
		String reportName = "D:/ASL/cr-reports/opsumm.rpt";
		String reportTitle = "Test Report";
		boolean attachment = true;
		Map<String, Object> reportParams = new HashMap<>();
		System.out.println(new Date());
		reportParams.put("zid", "900010");
		reportParams.put("fdate", new Date());
		reportParams.put("tdate", new Date());
		reportParams.put("terminal", "1");
		reportParams.put("rpttype", "Summary");
		reportParams.put("div", "1");

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
