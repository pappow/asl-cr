package com.asl.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asl.model.DropdownOption;
import com.asl.model.FormFieldBuilder;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Service("cccdService")
public class CCCDReportFieldServiceImpl extends AbstractReportService {

	public List<FormFieldBuilder> getReportFields() {
		return generateCCCD();
	}

	private List<FormFieldBuilder> generateCCCD() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, sessionManager.getBusinessId()));

		fieldsList.add(FormFieldBuilder.generateSearchField(2, "User", "search/item/itemcode", "", false));

		List<DropdownOption> postTerminalOptions = new ArrayList<>();
		postTerminalOptions.add(new DropdownOption("", "Select"));
		postTerminalOptions.add(new DropdownOption("01", "01"));
		postTerminalOptions.add(new DropdownOption("02", "02"));
		postTerminalOptions.add(new DropdownOption("03", "03"));
		postTerminalOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(3, "Pos terminal", postTerminalOptions, null, false));

		fieldsList.add(FormFieldBuilder.generateDateField(4, "Date", new Date(), true));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(5, "Report view", reportViewOptions, "PDF", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
