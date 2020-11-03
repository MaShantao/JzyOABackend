package com.marico.ncovreportsystem.util;

public class StringUtil {
	
	public static String fixInvalidTime(String timeStr) {
		return timeStr.replace("00:00", "");
	}
}
