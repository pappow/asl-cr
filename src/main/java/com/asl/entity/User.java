package com.asl.entity;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Dec 28, 2020
 */
@Data
public class User {

	private Long userId;
	private String username;
	private String password;
	private boolean active;
	private String businessId;
	private String emailAddress;
	private String roles;
}
