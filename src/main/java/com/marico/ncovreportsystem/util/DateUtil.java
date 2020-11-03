package com.marico.ncovreportsystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String getDate() {
		 SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日");
		 return myFmt.format(new Date());
	}
	
	public static String getMintueDate() {
		 SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		 return myFmt.format(new Date());
	}
	
}
