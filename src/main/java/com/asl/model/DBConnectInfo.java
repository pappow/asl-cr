package com.asl.model;

import lombok.Data;

@Data
public class DBConnectInfo {

	private String jndiName;
	private String connectionURL;
	private String driverName;
	private String username;
	private String password;
}
