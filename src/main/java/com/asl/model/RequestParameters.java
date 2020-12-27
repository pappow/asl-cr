package com.asl.model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Data
public class RequestParameters {

	private String reportCode;
	private String status;

	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	private String param7;
	private String param8;
	private String param9;
	private String param11;
	private String param12;
	private String param13;
	private String param14;
	private String param15;
	private String param16;
	private String param17;
	private String param18;
	private String param19;
	private String param20;
	private String param21;
	private String param22;
	private String param23;
	private String param24;
	private String param25;
	private String param26;
	private String param27;
	private String param28;
	private String param29;
	private String param30;

	public static String invokeGetter(Object obj, String variableName){
		try {
			PropertyDescriptor pd = new PropertyDescriptor(variableName, obj.getClass());
			Method getter = pd.getReadMethod();
			Object f = getter.invoke(obj);
			return (String) f;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
