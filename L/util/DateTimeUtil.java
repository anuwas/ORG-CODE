package com.mes.lcr.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd"; //$NON-NLS-1$

	public static final String DATE_FORMAT_YYDDD= "yyDDD"; //$NON-NLS-1$
	public static final String FORMAT_ddMMyy = "ddMMyy";

	private DateTimeUtil() {
	    throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	  }

	public static String getFirstDateOfPreviousMonthStr(String datePattern) {
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);

		aCalendar.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = aCalendar.getTime();

	    SimpleDateFormat format = new SimpleDateFormat(datePattern);
	    return format.format(firstDateOfPreviousMonth);
	}

	public static String getLastDateOfPreviousMonthStr(String datePattern) {
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = aCalendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
	    return format.format(lastDateOfPreviousMonth);
	}
	
	public static Date getFirstDateOfPreviousMonthDate() {
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);

		aCalendar.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = aCalendar.getTime();

	    return firstDateOfPreviousMonth;
	}
	
	public static Date getLastDateOfPreviousMonthDate() {
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = aCalendar.getTime();
	    return lastDateOfPreviousMonth;
	}

	public static String getCurrentDateTime(String datePattern) {
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getFormattedDate(Date dt, String format)
	{
	    String result = ""; //$NON-NLS-1$

	    if(dt != null)
	    {
	        SimpleDateFormat df = new SimpleDateFormat(format);
	        result = df.format(dt);
	    }

	    return result;
	}
	
	public static String getPreviousDayDateStr(String datePattern) {
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		 Date previousDay = new Date();
		 previousDay .setTime(previousDay.getTime()-24*60*60*1000); 
		 return dateFormat.format(previousDay);
	} 
	
	
	public static Date getDateFromGivenStrDate(String pattern,String date) throws ParseException {
		SimpleDateFormat formatter1=new SimpleDateFormat(pattern);  
		return formatter1.parse(date);  
	}


}
