package com.asl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zubayer Ahamed
 * @since Dec 26, 2020
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@GetMapping("/{menuCode}")
	public String loadReportPage(@PathVariable String menuCode, Model model) {
		model.addAttribute("reportCode", menuCode.toLowerCase());
		return "pages/report/report";
	}
}
