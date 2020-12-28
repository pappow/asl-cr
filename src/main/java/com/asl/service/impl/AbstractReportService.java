package com.asl.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.asl.service.ReportFieldService;

/**
 * @author Zubayer Ahamed
 * @since Dec 28, 2020
 */
@Component
public abstract class AbstractReportService implements ReportFieldService {

	@Value("${zid}")
	protected String zid;
}
