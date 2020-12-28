package com.asl.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asl.model.DropdownOption;
import com.asl.model.FormFieldBuilder;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Service("ilService")
public class ILReportFieldServiceImpl extends AbstractReportService {

	public List<FormFieldBuilder> getReportFields() {
		return generateIL();
	}

	private List<FormFieldBuilder> generateIL() {
		List<FormFieldBuilder> fieldsList = new ArrayList<>();

		// zid
		fieldsList.add(FormFieldBuilder.generateHiddenField(1, sessionManager.getBusinessId()));

		fieldsList.add(FormFieldBuilder.generateSearchField(2, "Item Code", "/search/item/itemcode", "", true));

		List<DropdownOption> postOptions = new ArrayList<>();
		postOptions.add(new DropdownOption("", "Select"));
		postOptions.add(new DropdownOption("Add On's", "Add On's"));
		postOptions.add(new DropdownOption("Appetigers", "Appetigers"));
		postOptions.add(new DropdownOption("Beef Burgers", "Beef Burgers"));
		postOptions.add(new DropdownOption("Chicken Burgers", "Chicken Burgers"));
		postOptions.add(new DropdownOption("Chilled Coffee", "Chilled Coffee"));
		postOptions.add(new DropdownOption("Cold Beverages", "Cold Beverages"));
		postOptions.add(new DropdownOption("Hot Coffee", "Hot Coffee"));
		postOptions.add(new DropdownOption("Pasta", "Pasta"));
		postOptions.add(new DropdownOption("Set Meals", "Set Meals"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(3, "Category", postOptions, null, false));

		List<DropdownOption> outletOptions = new ArrayList<>();
		outletOptions.add(new DropdownOption("", "Select"));
		outletOptions.add(new DropdownOption("Active", "Active"));
		outletOptions.add(new DropdownOption("Inactive", "Inactive"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(4, "Status", outletOptions, null, false));

		List<DropdownOption> reportViewOptions = new ArrayList<>();
		reportViewOptions.add(new DropdownOption("PDF", "PDF"));
		fieldsList.add(FormFieldBuilder.generateDropdownField(5, "Report view", reportViewOptions, "PDF", true));

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
