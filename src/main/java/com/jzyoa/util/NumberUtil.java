package com.jzyoa.util;

import java.math.BigDecimal;

public class NumberUtil {

	public static boolean isNumeric(String str) {
		String bigStr = null;
		try {
			bigStr = new BigDecimal(str).toString();
		} catch (Exception e) {
			return false;// 异常 说明包含非数字。
		}
		return true;
	}

}
