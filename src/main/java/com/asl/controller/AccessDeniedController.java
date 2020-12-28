package com.asl.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 *
 */
@Slf4j
@Controller
@RequestMapping("/accessdenied")
public class AccessDeniedController extends ASLAbstractController {

	//@Autowired private UnAuthorizedAccessService unAuthorizedAccessService;

	@GetMapping
	public String loadAccessDeniedController(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) return "pages/accessdenied/accessdenied";

		log.warn("{}, trying to unauthorized access", auth.getName());
//		UnAuthorizedAccess ua = new UnAuthorizedAccess();
//		ua.setUsername(auth.getName());
//		unAuthorizedAccessService.save(ua);

		return "pages/accessdenied/accessdenied";
	}
}
