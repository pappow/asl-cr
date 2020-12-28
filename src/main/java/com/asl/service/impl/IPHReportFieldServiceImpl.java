package com.asl.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asl.model.DropdownOption;
import com.asl.model.FormFieldBuilder;
import com.ibm.icu.util.Calendar;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Service("iphService")
public class IPHReportFieldServiceImpl extends AbstractReportService {

	public List<FormFieldBuilder> getReportFields() {
		return generateIPH();
	}

	private List<FormFieldBuilder> generateIPH() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, sessionManager.getBusinessId()));

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -5);
		fieldsList.add(FormFieldBuilder.generateDateField(2, "From date", cal.getTime(), true));

		fieldsList.add(FormFieldBuilder.generateDateField(3, "To date", new Date(), true));

		fieldsList.add(FormFieldBuilder.generateSearchField(4, "Item", "/search/item/itemcode", "", true));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(5, "Report view", reportViewOptions, "PDF", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
