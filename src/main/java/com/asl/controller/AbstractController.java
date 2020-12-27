package com.asl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.asl.enums.ReportMenu;
import com.asl.service.ReportFieldService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Slf4j
@Component
public class AbstractController {

	private static final String ERROR = "Error is : {}, {}"; 

	@Autowired private ApplicationContext appContext;

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
