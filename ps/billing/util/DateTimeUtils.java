package com.mes.ps.billing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for date time related functionality.
 */
public class DateTimeUtils {
  private static final Logger LOG = LoggerFactory.getLogger(DateTimeUtils.class);
  private static final String FORMAT_yyyyMMdd = "yyyy-MM-dd";
  public static final String FORMAT_ddMMyy = "ddMMyy";

  /**
   * Utility method for parsing date string of 'yyyy-MM-dd' pattern to date object
   * @param date
   * @return
   */
  public static Date parseDate(String date) {
    try {
      return new SimpleDateFormat(FORMAT_yyyyMMdd).parse(date);
    } catch(Exception e) {
      return new Date();
    }
  }

  /**
   * Utility method to create start and end XMLGregorianCalendar object based on start and end date string of 'yyyy-MM-dd' pattern
   * @param startDate
   * @param endDate
   * @return
   */
  public static XMLGregorianCalendar[] parseDate(String startDate, String endDate) {
    SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_yyyyMMdd);
    XMLGregorianCalendar[] dates = new XMLGregorianCalendar[2];

    try {
      Date beginTxndate = formatter.parse(startDate);
      Date endTxnDate = formatter.parse(endDate);
      GregorianCalendar endTransactionDate = new GregorianCalendar();
      endTransactionDate.setTime(endTxnDate);

      GregorianCalendar beginTransactionDate = new GregorianCalendar();
      beginTransactionDate.setTime(beginTxndate);

      XMLGregorianCalendar beginTransDate = DatatypeFactory.newInstance()
        .newXMLGregorianCalendar(beginTransactionDate.get(Calendar.YEAR),
          beginTransactionDate.get(Calendar.MONTH)+1,
          beginTransactionDate.get(Calendar.DAY_OF_MONTH),
          00, 00, 00, 00, DatatypeConstants.FIELD_UNDEFINED);

      XMLGregorianCalendar endTransDate = DatatypeFactory.newInstance()
        .newXMLGregorianCalendar(endTransactionDate.get(Calendar.YEAR),
          endTransactionDate.get(Calendar.MONTH)+1,
          endTransactionDate.get(Calendar.DAY_OF_MONTH),
          23, 59, 59, 00, DatatypeConstants.FIELD_UNDEFINED);

      dates[0] = beginTransDate;
      dates[1] = endTransDate;
    } catch (ParseException | DatatypeConfigurationException e) {
      LOG.error("Error: ", e);
    }

    return dates;
  }

  /**
   * Utility method for daily job execution date
   * @param executionDate
   * @return
   */
  public static Date getDailyJobDate(Date executionDate) {
	  Calendar cal = Calendar.getInstance();
	  if(executionDate != null){
		  cal.setTime(executionDate);
	  }else {
		  cal.setTime(new Date());
	  }
	  cal.add(Calendar.DATE, -1);
	  return cal.getTime();
  }
  
  
  /**
   * Wrapper utility method for daily job execution date
   * @param executionDate
   * @return
   */
  public static String getDailyJobDateAsString(Date executionDate) {
	  Date dt = getDailyJobDate(executionDate);
	  return getDateString(dt);
  }
  

  /**
   * Wrapper utility method for monthly billing job
   * @param date
   * @return
   */
  public static Date getDate(Date date) {
    return getDate(date, 0, -1);
  }

  /**
   * Wrapper utility method for monthly billing job
   * @param date
   * @param day
   * @return
   */
  public static Date getDate(Date date, int day) {
    return getDate(date, day, 0);
  }

  /**
   * Utility method for monthly billing job
   * if day is 0 then exact date will be returned
   * if day is -1 then first day of the month date will be returned
   * if day is 1 then last day of the month date will be returned
   * @param date
   * @param day
   * @param deductNumberOfMonths
   * @return
   */
  public static Date getDate(Date date, int day, int deductNumberOfMonths) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.MONTH, deductNumberOfMonths);

    if (day == -1) {
      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
    } else if (day == 1){
      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    return cal.getTime();
  }

  /**
   * Utility method to create date string from date object
   * @param date
   * @return
   */
  public static String getDateString(Date date) {
    return new SimpleDateFormat(FORMAT_yyyyMMdd).format(date);
  }

  /**
   * Utility method to create date string from XMLGregorianCalendar object
   * @param cal
   * @return
   */
  public static String getDateString(XMLGregorianCalendar cal) {
    return new SimpleDateFormat(FORMAT_yyyyMMdd).format(cal.toGregorianCalendar().getTime());
  }
    
}
