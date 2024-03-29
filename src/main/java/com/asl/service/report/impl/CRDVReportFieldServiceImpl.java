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
@Service("crdvService")
public class CRDVReportFieldServiceImpl extends AbstractReportService {

	public List<FormFieldBuilder> getReportFields() {
		return generateCRDV();
	}

	private List<FormFieldBuilder> generateCRDV() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, sessionManager.getBusinessId()));

		fieldsList.add(FormFieldBuilder.generateSearchField(2, "User", "search/user", "", false));

		List<DropdownOption> fromTerminalOptions = new ArrayList<>();
		fromTerminalOptions.add(new DropdownOption("", "Select"));
		fromTerminalOptions.add(new DropdownOption("01", "01"));
		fromTerminalOptions.add(new DropdownOption("02", "02"));
		fromTerminalOptions.add(new DropdownOption("03", "03"));
		fromTerminalOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(3, "From terminal", fromTerminalOptions, null, false));

		List<DropdownOption> toTerminalOptions = new ArrayList<>();
		toTerminalOptions.add(new DropdownOption("", "Select"));
		toTerminalOptions.add(new DropdownOption("01", "01"));
		toTerminalOptions.add(new DropdownOption("02", "02"));
		toTerminalOptions.add(new DropdownOption("03", "03"));
		toTerminalOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(4, "To terminal", toTerminalOptions, null, false));

		fieldsList.add(FormFieldBuilder.generateDateField(5, "From date", new Date(), true));

		fieldsList.add(FormFieldBuilder.generateDateField(6, "To date", new Date(), true));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(7, "Report view", reportViewOptions, "PDF", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
