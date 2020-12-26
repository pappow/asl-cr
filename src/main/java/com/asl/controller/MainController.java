/**
 * 
 */
package com.asl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zubayer
 *
 */
@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String loadHomePage(Model model) {
		return "pages/business/business";
	}


	
	
}
