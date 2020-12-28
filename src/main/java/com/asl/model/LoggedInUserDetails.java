package com.asl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Dec 28, 2020
 */
@Data
public class LoggedInUserDetails {

	private String username;
	private String emailAddress;
	private String businessId;
	private List<String> roles = new ArrayList<>();
	private String ipAddress;
}
