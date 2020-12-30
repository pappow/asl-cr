package com.asl.controller;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 * @since 27-12-2020
 */
@Slf4j
@Controller
@RequestMapping("/")
public class MainController extends ASLAbstractController {

	private static final String LOGAIN_PAGE_PATH = "pages/login/fakelogin";
	private static final String OUTSIDE_USERS_NAME = "anonymousUser";

	@GetMapping
	public String loadHomePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		if (OUTSIDE_USERS_NAME.equalsIgnoreCase(username)) {
			if(sessionManager.getFromMap("FAKE_LOGIN_USER") != null) {
				return "redirect:/business";
			}

			model.addAttribute("pageTitle", "Login");
			log.debug("Login page called at {}", new Date());
			return LOGAIN_PAGE_PATH;
		}

		return "pages/business/business";
	}

}
