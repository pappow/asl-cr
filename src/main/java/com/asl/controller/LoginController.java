/**
 * 
 */
package com.asl.controller;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 *
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController extends ASLAbstractController {

	private static final String LOGAIN_PAGE_PATH = "pages/login/login";
	private static final String OUTSIDE_USERS_NAME = "anonymousUser";

	@GetMapping
	public String loadLoginPage(Model model, @RequestParam(required = false) String device) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		if (OUTSIDE_USERS_NAME.equalsIgnoreCase(username)) {
			model.addAttribute("pageTitle", "Login");
			log.debug("Login page called at {}", new Date());
			return LOGAIN_PAGE_PATH;
		}
		return "redirect:/";
	}
}
