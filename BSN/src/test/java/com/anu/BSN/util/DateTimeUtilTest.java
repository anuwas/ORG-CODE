package com.mes.lc.billing.util;

import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import com.mes.lc.util.DateTimeUtil;


public class DateTimeUtilTest {
	public static final String DATE_FORMAT_DD_MM_YY = "dd/MM/yyyy"; 
	
	@Test
	public void getFirstDateOfPreviousMonthStrTest() {
		String dateStringUtil = DateTimeUtil.getFirstDateOfPreviousMonthStr(DATE_FORMAT_DD_MM_YY);
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		aCalendar.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = aCalendar.getTime();
	    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY);
	    String dateString = format.format(firstDateOfPreviousMonth);
		Assert.assertEquals(dateStringUtil, dateString);
		
	}
	
	@Test
	public void getLastDateOfPreviousMonthStrTest() {
		String dateStringUtil = DateTimeUtil.getLastDateOfPreviousMonthStr(DATE_FORMAT_DD_MM_YY);
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = aCalendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY);
	    String dateString = format.format(lastDateOfPreviousMonth);
	    Assert.assertEquals(dateStringUtil, dateString);
	}
	
	@Test
	public void getFirstDateOfPreviousMonthDateTest() {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY);  
		 
		Date dateUtil = DateTimeUtil.getFirstDateOfPreviousMonthDate();
		String dateUtilStr = dateFormat.format(dateUtil);
		
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		aCalendar.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = aCalendar.getTime();
		
		String firstDateOfPreviousMonthStr = dateFormat.format(firstDateOfPreviousMonth);
		
		Assert.assertEquals(dateUtilStr, firstDateOfPreviousMonthStr);
	}
	
	@Test
	public void getLastDateOfPreviousMonthDateTest() {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY);
		
		Date dateUtil = DateTimeUtil.getLastDateOfPreviousMonthDate();
		String dateUtilStr = dateFormat.format(dateUtil);
		
		Calendar aCalendar = Calendar.getInstance();
		Date date = new Date();
		aCalendar.setTime(date);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = aCalendar.getTime();
		
		String lastDateOfPreviousMonthStr = dateFormat.format(lastDateOfPreviousMonth);
		
		Assert.assertEquals(dateUtilStr, lastDateOfPreviousMonthStr);
	}
	
	@Test
	public void getPreviousDayDateStrTest() {
		String dateStringUtil = DateTimeUtil.getPreviousDayDateStr(DATE_FORMAT_DD_MM_YY);
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY);
		 Date previousDay = new Date();
		 previousDay .setTime(previousDay.getTime()-24*60*60*1000); 
		 String dateString = dateFormat.format(previousDay);
		 Assert.assertEquals(dateStringUtil, dateString);
	}
	
	@Test
	public void getFormattedDateTest() throws ParseException {
		Date dateObjUtil = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY).parse("05/02/2018");
		String dateStringUtil = DateTimeUtil.getFormattedDate(dateObjUtil,DATE_FORMAT_DD_MM_YY);
		
		Date dateObj = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY).parse("05/02/2018");
		String dateString = DateTimeUtil.getFormattedDate(dateObj,DATE_FORMAT_DD_MM_YY);
		
		Assert.assertEquals(dateStringUtil, dateString);
	}
	
	@Test
	public void getCurrentDateTimeTest() {
		String currentDateUtil = DateTimeUtil.getCurrentDateTime(DATE_FORMAT_DD_MM_YY);
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY);
		Date date = new Date();
		String currentDateStr = dateFormat.format(date);
		Assert.assertEquals(currentDateUtil, currentDateStr);
	}
	
	@Test
	public void getDateFromGivenStrDateTest() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_DD_MM_YY);
		
		Date utilDate = DateTimeUtil.getDateFromGivenStrDate(DATE_FORMAT_DD_MM_YY, "10/10/2018");
		String utilDateStr = dateFormat.format(utilDate);
		
		
		Assert.assertEquals("10/10/2018", utilDateStr);
	}
	
	@Test
	public void checkPrivateConstructor(){
		try {
			Constructor<DateTimeUtil> c = DateTimeUtil.class.getDeclaredConstructor();
			c.setAccessible(true); 
			DateTimeUtil bu = c.newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
