package com.asl.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asl.enums.FormFieldType;
import com.asl.model.DropdownValue;
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
		FormFieldBuilder ffb = new FormFieldBuilder();
		ffb.setSeqn(0);
		ffb.setId("param0");
		ffb.setName("param0");
		ffb.setFieldType(FormFieldType.HIDDEN);
		ffb.setInputValue("900010");
		fieldsList.add(ffb);

		ffb = new FormFieldBuilder();
		ffb.setSeqn(1);
		ffb.setId("param1");
		ffb.setName("param1");
		ffb.setFieldType(FormFieldType.DATE);
		ffb.setPrompt("From date");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -5);
		ffb.setDateValue(cal.getTime());
		ffb.setRequired(true);
		fieldsList.add(ffb);

		ffb = new FormFieldBuilder();
		ffb.setSeqn(2);
		ffb.setId("param2");
		ffb.setName("param2");
		ffb.setFieldType(FormFieldType.DATE);
		ffb.setPrompt("To date");
		ffb.setRequired(true);
		fieldsList.add(ffb);

		ffb = new FormFieldBuilder();
		ffb.setSeqn(3);
		ffb.setId("param3");
		ffb.setName("param3");
		ffb.setFieldType(FormFieldType.DROPDOWN);
		ffb.setPrompt("Outlet");
		ffb.getDropdownValues().add(new DropdownValue("", "Select"));
		ffb.getDropdownValues().add(new DropdownValue("01", "01"));
		ffb.getDropdownValues().add(new DropdownValue("02", "02"));
		ffb.getDropdownValues().add(new DropdownValue("03", "03"));
		ffb.getDropdownValues().add(new DropdownValue("04", "04"));
		ffb.setRequired(true);
		fieldsList.add(ffb);

		ffb = new FormFieldBuilder();
		ffb.setSeqn(4);
		ffb.setId("param4");
		ffb.setName("param4");
		ffb.setFieldType(FormFieldType.DROPDOWN);
		ffb.setPrompt("Pos terminal");
		ffb.getDropdownValues().add(new DropdownValue("", "Select"));
		ffb.getDropdownValues().add(new DropdownValue("01", "01"));
		ffb.getDropdownValues().add(new DropdownValue("02", "02"));
		ffb.getDropdownValues().add(new DropdownValue("03", "03"));
		ffb.getDropdownValues().add(new DropdownValue("04", "04"));
		ffb.setRequired(true);
		fieldsList.add(ffb);

		ffb = new FormFieldBuilder();
		ffb.setSeqn(5);
		ffb.setId("param5");
		ffb.setName("param5");
		ffb.setFieldType(FormFieldType.DROPDOWN);
		ffb.setPrompt("Report type");
		ffb.getDropdownValues().add(new DropdownValue("Synopsis", "Synopsis"));
		ffb.getDropdownValues().add(new DropdownValue("Summary", "Summary"));
		fieldsList.add(ffb);

		ffb = new FormFieldBuilder();
		ffb.setSeqn(6);
		ffb.setId("param6");
		ffb.setName("param6");
		ffb.setFieldType(FormFieldType.DROPDOWN);
		ffb.setPrompt("Report view");
		ffb.getDropdownValues().add(new DropdownValue("PDF", "PDF"));
		fieldsList.add(ffb);

		fieldsList.sort(Comparator.comparing(FormFieldBuilder::getSeqn));
		return fieldsList;
	}
}
