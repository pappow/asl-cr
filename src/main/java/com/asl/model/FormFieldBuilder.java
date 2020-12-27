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
	private String id;
	private String name;
	private String cssClass;
	private boolean disabled;
	private boolean required;
	private int seqn;

	private String inputValue;
	private Date dateValue;
	private List<DropdownValue> dropdownValues = new ArrayList<>();
}
