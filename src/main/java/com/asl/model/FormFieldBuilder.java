package com.asl.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.asl.enums.FormFieldType;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Data
public class FormFieldBuilder {

	private FormFieldType fieldType;
	private String prompt;
	private String fieldId;
	private String fieldName;
	private String cssClass;
	private boolean disabled;
	private boolean required;
	private int seqn;

	private String defaultInputValue;
	private Date defaultDateValue;
	private List<DropdownOption> options = new ArrayList<>();
	private String selectedOption;
	private String searchUrl;
	private String defaultSearchVal;
	private String searchVal;
	private String searchDes;

	public void setSeqn(int seqn) {
		this.seqn = seqn;
		this.fieldId = "param" + seqn;
		this.fieldName = "param" + seqn;
	}

	/**
	 * Generate Hidden input field
	 * @param sequence
	 * @param fieldType
	 * @param defaultValue
	 * @return {@link FormFieldBuilder}
	 */
	public static FormFieldBuilder generateHiddenField(int sequence, String defaultValue) {
		FormFieldBuilder ffb = new FormFieldBuilder();
		ffb.setSeqn(sequence);
		ffb.setFieldType(FormFieldType.HIDDEN);
		ffb.setDefaultInputValue(defaultValue);
		return ffb;
	}

	/**
	 * Generate Date field
	 * @param sequence
	 * @param prompt
	 * @param defaultValue
	 * @param required
	 * @return {@link FormFieldBuilder}
	 */
	public static FormFieldBuilder generateDateField(int sequence, String prompt, Date defaultValue, boolean required) {
		FormFieldBuilder ffb = new FormFieldBuilder();
		ffb.setSeqn(sequence);
		ffb.setPrompt(prompt);
		ffb.setFieldType(FormFieldType.DATE);
		ffb.setRequired(required);
		ffb.setDefaultDateValue(defaultValue);
		return ffb;
	}

	/**
	 * Generate Dropdown Field
	 * @param sequence
	 * @param prompt
	 * @param options
	 * @param selectedOption
	 * @param required
	 * @return {@link FormFieldBuilder}
	 */
	public static FormFieldBuilder generateDropdownField(int sequence, String prompt, List<DropdownOption> options, String selectedOption, boolean required) {
		FormFieldBuilder ffb = new FormFieldBuilder();
		ffb.setSeqn(sequence);
		ffb.setPrompt(prompt);
		ffb.setFieldType(FormFieldType.DROPDOWN);
		ffb.setOptions(options);
		ffb.setSelectedOption(selectedOption);
		ffb.setRequired(required);
		return ffb;
	}

	/**
	 * Generate search field
	 * @param sequence
	 * @param prompt
	 * @param searchUrl
	 * @param defaultValue
	 * @param required
	 * @return {@link FormFieldBuilder}
	 */
	public static FormFieldBuilder generateSearchField(int sequence, String prompt, String searchUrl, String defaultValue, boolean required) {
		FormFieldBuilder ffb = new FormFieldBuilder();
		ffb.setSeqn(sequence);
		ffb.setPrompt(prompt);
		ffb.setFieldType(FormFieldType.SEARCH);
		ffb.setSearchUrl(searchUrl);
		ffb.setDefaultSearchVal(defaultValue);
		ffb.setRequired(required);
		return ffb;
	}
}
