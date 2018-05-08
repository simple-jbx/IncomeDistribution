package config;

import java.util.UUID;

public class DefalutValue {
	public final static String DEFAULT_STRING_VALUE = "-";
	public final static int DEFAULT_INITIALIZATION_INT_VALUE = 2;
	public final static int DEFAULT_NOT_DELETE_INT_VALUE = 0;
	public final static int DEFAULT_DELETE_INT_VALUE = 1;
	public static String DEFAULT_VALUE_OF_ID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
