package com.asl.service.report.impl;

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
@Service("setService")
public class SETReportFieldServiceImpl extends AbstractReportService {

	public List<FormFieldBuilder> getReportFields() {
		return generateSET();
	}

	private List<FormFieldBuilder> generateSET() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, sessionManager.getBusinessId()));

		fieldsList.add(FormFieldBuilder.generateDateField(2, "From date", new Date(), true));

		fieldsList.add(FormFieldBuilder.generateDateField(3, "To date", new Date(), true));

		List<DropdownOption> posTerminalOptions = new ArrayList<>();
		posTerminalOptions.add(new DropdownOption("", "Select"));
		posTerminalOptions.add(new DropdownOption("01", "01"));
		posTerminalOptions.add(new DropdownOption("02", "02"));
		posTerminalOptions.add(new DropdownOption("03", "03"));
		posTerminalOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(4, "Pos Terminal", posTerminalOptions, null, false));

		List<DropdownOption> eatInOptions = new ArrayList<>();
		eatInOptions.add(new DropdownOption("", "Select"));
		eatInOptions.add(new DropdownOption("Eat In", "Eat In"));
		eatInOptions.add(new DropdownOption("Take Away", "Take Away"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(5, "Eat in?", eatInOptions, null, false));

		fieldsList.add(FormFieldBuilder.generateSearchField(6, "Item", "search/item/itemcode", "", false));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(7, "Report view", reportViewOptions, "PDF", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
