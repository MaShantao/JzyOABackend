package com.marico.ncovreportsystem.util;

import java.util.UUID;

public class UUIDUtil {
	/**
	 * 随机生成id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString();
	}
	
	public static String getCode(){
		return getId().replace("-", "").toUpperCase();
	}

}
