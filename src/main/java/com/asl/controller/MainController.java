package com.asl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zubayer Ahamed
 * @since 27-12-2020
 */
@Controller
@RequestMapping("/")
public class MainController extends ASLAbstractController {

	@GetMapping
	public String loadHomePage(Model model) {
		return "pages/business/business";
	}

}
