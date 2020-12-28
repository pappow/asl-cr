package com.asl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.asl.config.AppConfig;
import com.asl.enums.ReportMenu;
import com.asl.service.ASLSessionManager;
import com.asl.service.ReportFieldService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Slf4j
@Component
public class ASLAbstractController {

	protected static final String DEFAULT_SYSTEM_NAME = "ASL Cristal Report";
	protected static final String PROLIFE_LIST_CODE = "XISPROFILE2020";
	protected static final String PROLIFE_LINES_LIST_CODE = "PROFILE";
	protected static final String ERROR = "Error is : {}, {}"; 

	@Autowired protected ApplicationContext appContext;
	@Autowired protected AppConfig appConfig;
	@Autowired protected ASLSessionManager sessionManager;

	@ModelAttribute("brandName")
	protected String brandName() {
		return DEFAULT_SYSTEM_NAME;
	}

	protected ReportFieldService getReportFieldService(ReportMenu reportMenu) {
		if(reportMenu == null) return null;
		try {
			return (ReportFieldService) appContext.getBean(reportMenu.getCode().toLowerCase() + "Service");
		} catch (Exception e) {
			log.error(ERROR, e.getMessage(), e);
			return null;
		}
	}
}
