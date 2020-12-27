package com.asl.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asl.model.DropdownOption;
import com.asl.model.FormFieldBuilder;
import com.asl.service.ReportFieldService;
import com.ibm.icu.util.Calendar;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Service("srsService")
public class SRSReportFieldServiceImpl implements ReportFieldService {

	public List<FormFieldBuilder> getReportFields() {
		return generateSRS();
	}

	private List<FormFieldBuilder> generateSRS() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, "900010"));
		// status
		fieldsList.add(FormFieldBuilder.generateHiddenField(2, "1"));

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -5);
		fieldsList.add(FormFieldBuilder.generateDateField(3, "From date", cal.getTime(), true));

		fieldsList.add(FormFieldBuilder.generateDateField(4, "To date", new Date(), true));

		List<DropdownOption> outletOptions = new ArrayList<>();
		outletOptions.add(new DropdownOption("", "Select"));
		outletOptions.add(new DropdownOption("01", "01"));
		outletOptions.add(new DropdownOption("02", "02"));
		outletOptions.add(new DropdownOption("03", "03"));
		outletOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(5, "Outlet", outletOptions, "01", true));

		List<DropdownOption> postOptions = new ArrayList<>();
		postOptions.add(new DropdownOption("", "Select"));
		postOptions.add(new DropdownOption("01", "01"));
		postOptions.add(new DropdownOption("02", "02"));
		postOptions.add(new DropdownOption("03", "03"));
		postOptions.add(new DropdownOption("04", "04"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(6, "Pos terminal", postOptions, "01", true));

		List<DropdownOption> reportTypeOptions = new ArrayList<>();
		reportTypeOptions.add(new DropdownOption("Synopsis", "Synopsis"));
		reportTypeOptions.add(new DropdownOption("Summary", "Summary"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(7, "Report type", reportTypeOptions, "Synopsis", true));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(8, "Report view", reportViewOptions, "PDF", true));

		fieldsList.add(FormFieldBuilder.generateSearchField(9, "Search", "/search/countries", "", true));
		fieldsList.add(FormFieldBuilder.generateSearchField(10, "Search2", "", "", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
