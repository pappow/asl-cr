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
@Service("drService")
public class DRReportFieldServiceImpl extends AbstractReportService {

	public List<FormFieldBuilder> getReportFields() {
		return generateDR();
	}

	private List<FormFieldBuilder> generateDR() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, sessionManager.getBusinessId()));

		fieldsList.add(FormFieldBuilder.generateDateField(2, "From date", new Date(), true));

		fieldsList.add(FormFieldBuilder.generateDateField(3, "To date", new Date(), true));

		List<DropdownOption> outletOptions = new ArrayList<>();
		outletOptions.add(new DropdownOption("", "Select"));
		outletOptions.add(new DropdownOption("01", "01"));
		outletOptions.add(new DropdownOption("02", "02"));
		outletOptions.add(new DropdownOption("03", "03"));
		outletOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(4, "Outlet", outletOptions, null, false));

		List<DropdownOption> postOptions = new ArrayList<>();
		postOptions.add(new DropdownOption("", "Select"));
		postOptions.add(new DropdownOption("01", "01"));
		postOptions.add(new DropdownOption("02", "02"));
		postOptions.add(new DropdownOption("03", "03"));
		postOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(5, "Pos terminal", postOptions, null, false));

		List<DropdownOption> reportTypeOptions = new ArrayList<>();
		reportTypeOptions.add(new DropdownOption("Synopsis", "Synopsis"));
		reportTypeOptions.add(new DropdownOption("Summary", "Summary"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(6, "Report type", reportTypeOptions, "Summary", true));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(7, "Report view", reportViewOptions, "PDF", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
