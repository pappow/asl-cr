package com.asl.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asl.entity.Xusers;

/**
 * @author Zubayer Ahamed
 * @since Dec 30, 2020
 */
@Controller
@RequestMapping("/business")
public class BusinessDashboardController extends ASLAbstractController {

	@SuppressWarnings("unchecked")
	@GetMapping
	public String loadBusinessDashboard(Model model) {
		List<Xusers> list = null;
		if(sessionManager.getFromMap("FAKE_LOGIN_USER") != null) {
			list = (List<Xusers>) sessionManager.getFromMap("FAKE_LOGIN_USER");
		}
		if(list == null || list.isEmpty()) {
			return "redirect:/";
		}

		model.addAttribute("business", list);

		return "pages/business/business-dashboard";
	}
}
