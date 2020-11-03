package com.jzyoa.util;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {
	
	private static String[] IEBrowserSignals = { "MSIE", "Trident", "Edge" };

	public static boolean isMSBrowser(HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");
		for (String signal : IEBrowserSignals) {
			if (userAgent.contains(signal))
				return true;
		}
		return false;
	}
}