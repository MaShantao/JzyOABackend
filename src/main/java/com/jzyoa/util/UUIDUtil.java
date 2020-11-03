package com.jzyoa.util;

import java.util.UUID;

public class UUIDUtil {
	
	public static String getId(){
		return UUID.randomUUID().toString();
	}
	
	public static String getCode(){
		return getId().replace("-", "").toUpperCase();
	}

}
