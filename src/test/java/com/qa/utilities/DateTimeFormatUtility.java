package com.qa.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatUtility {

	private static Date date=new Date();
	private static SimpleDateFormat format;
	
	public static String getDateAndTime() {
		
		format= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String formattedDateTime=format.format(date);
		return formattedDateTime;
	}
	
	public static String getTime() {
		
		format= new SimpleDateFormat("HH-mm-ss");
		String formattedDateTime=format.format(date);
		return formattedDateTime;
	}

}
