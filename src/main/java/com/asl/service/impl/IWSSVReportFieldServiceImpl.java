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
@Service("iwssvService")
public class IWSSVReportFieldServiceImpl extends AbstractReportService {

	public List<FormFieldBuilder> getReportFields() {
		return generateIWSSV();
	}

	private List<FormFieldBuilder> generateIWSSV() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, sessionManager.getBusinessId()));

		fieldsList.add(FormFieldBuilder.generateDateField(2, "From date", new Date(), true));

		fieldsList.add(FormFieldBuilder.generateDateField(3, "To date", new Date(), true));

		fieldsList.add(FormFieldBuilder.generateSearchField(4, "Item", "search/item/itemcode", "", false));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(5, "Report view", reportViewOptions, "PDF", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
