package com.nepxion.util.time;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune 任浩军
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class TimeUtil
{
	/**
	 * 获取当前年份
	 */
	public static int getCurrentYear()
	{
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * 获取当前月份
	 */
	public static int getCurrentMonth()
	{
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取当前日子
	 */
	public static int getCurrentDay()
	{
		return Calendar.getInstance().get(Calendar.DATE);
	}
	
	/**
	 * 获取当前小时
	 */
	public static int getCurrentHour()
	{
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 获取当前分钟
	 */
	public static int getCurrentMinute()
	{
		return Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	/**
	 * 获取当前秒
	 */
	public static int getCurrentSecond()
	{
		return Calendar.getInstance().get(Calendar.SECOND);
	}
	
	/**
	 * 获取当前毫秒
	 */
	public static int getCurrentMilliSecond()
	{
		return Calendar.getInstance().get(Calendar.MILLISECOND);
	}
	
	/**
	 * 获取当前完整的日期和时间，格式为yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentDateTime()
	{
		return getDateTime(new Date());
	}
	
	/**
	 * 获取某时刻的完整的日期和时间, 格式为yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime(Date date)
	{
		return getFormatString(date, getDateTimeFormat());
	}
	
	/**
	 * 获取当前日期，格式为yyyy-MM-dd
	 */
	public static String getCurrentDate()
	{
		return getDate(new Date());
	}
	
	/**
	 * 获取某个日期的字符串格式，格式为yyyy-MM-dd
	 */
	public static String getDate(Date date)
	{
		return getFormatString(date, getDateFormat());
	}
	
	/**
	 * 获取当前时刻的时间，格式为HH:mm:ss
	 */
	public static String getCurrentTime()
	{
		return getTime(new Date());
	}
	
	/**
	 * 获取某时刻的时间，格式为HH:mm:ss
	 */
	public static String getTime(Date time)
	{
		return getFormatString(time, getTimeFormat());
	}
	
	/**
	 * 转化时间格式为字符串格式的通用方法
	 */
	public static String getFormatString(Date date, DateFormat dateFormat)
	{
		return dateFormat.format(date);
	}
	
	/**
	 * 获取今天是一个星期的第几天
	 */
	public static int getCurrentDayOfWeek()
	{
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 获取某天是一个星期的第几天
	 */
	public static int getDayOfWeek(int year, int month, int date)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 获取今天所在的星期是当月的第几个星期
	 */
	public static int getCurrentWeekOfMonth()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * 获取某天所在的星期是当月的第几个星期
	 */
	public static int getWeekOfMonth(int year, int month, int date)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * 获取今天所在的星期是一年的第几个星期
	 */
	public static int getCurrentWeekOfYear()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * 获取某天所在的星期是一年的第几个星期
	 */
	public static int getWeekOfYear(int year, int month, int date)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * 根据完整的日期和时间，获取日期对象，格式为yyyy-MM-dd HH:mm:ss
	 */
	public static Date parseDateTime(String date)
	{
		return parseFormatString(date, getDateTimeFormat());
	}
	
	/**
	 * 根据完整的日期，获取日期对象，格式为yyyy-MM-dd
	 */
	public static Date parseDate(String date)
	{
		return parseFormatString(date, getDateFormat());
	}
	
	/**
	 * 根据完整的时间，获取日期对象，格式为HH:mm:ss
	 */
	public static Date parseTime(String time)
	{
		return parseFormatString(time, getTimeFormat());
	}
	
	/**
	 * 转化字符串格式为时间格式的通用方法
	 */
	public static Date parseFormatString(String dateString, DateFormat dateFormat)
	{
		dateString = dateString.trim();
		Date date = null;
		try
		{
			date = dateFormat.parse(dateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 解析当地夏令时间和标准时间之间的偏差，一般为一小时；如传入的为非夏令时间，则偏差值为0
	 */
	public static int getDSTOffset(Date date)
	{
		return getDSTOffset(date, TimeZone.getDefault());
	}
	
	/**
	 * 解析当地夏令时间和标准时间之间的偏差，一般为一小时；如传入的为非夏令时间，则偏差值为0
	 */
	public static int getDSTOffset(Date date, TimeZone timeZone)
	{				
		if (timeZone.inDaylightTime(date))
		{
			int offset = timeZone.getOffset(date.getTime()) - timeZone.getRawOffset();
			return offset;
		}
		return 0;
	}
	
	/**
	 * 根据完整的时间，获取GregorianCalendar对象
	 */
	public static GregorianCalendar parseCalendar(String time)
	{
		GregorianCalendar gc = new GregorianCalendar();
		Date date = parseTime(time);
		gc.setTime(date);
		return gc;
	}
	
	/**
	 * 获取两个长时间差的时间格式
	 */
	public static String getTimeInterval(long startTimeInMillis, long endTimeInMillis)
	{
		long timeInMillis = Math.abs((endTimeInMillis - startTimeInMillis) / 1000);
		
		long hours = timeInMillis / 3600;
		timeInMillis = timeInMillis - (hours * 3600);
		
		long minutes = timeInMillis / 60;
		timeInMillis = timeInMillis - (minutes * 60);
		
		long seconds = timeInMillis;
		
		return getTimeString(hours, minutes, seconds);
	}
	
	/**
	 * 判断时间time1是否在时间time2之前，格式为yyyy-MM-dd HH:mm:ss
	 */
	public static boolean isTimeBefore(String time1, String time2)
	{
		return isTimeBefore(time1, time2, getDateTimeFormat());
	}
	
	/**
	 * 判断时间time1是否在时间time2之前
	 */
	public static boolean isTimeBefore(String time1, String time2, DateFormat dateFormat)
	{
		time1 = time1.trim();
		time2 = time2.trim();
		try
		{
			return dateFormat.parse(time1).before(dateFormat.parse(time2));
		}
		catch (ParseException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 判断当前时间是否在时间time2之前，格式为yyyy-MM-dd HH:mm:ss
	 */
	public static boolean isTimeBefore(String time2)
	{
		return isTimeBefore(time2, getDateTimeFormat());
	}
	
	/**
	 * 判断当前时间是否在时间time2之前
	 */
	public static boolean isTimeBefore(String time2, DateFormat dateFormat)
	{
		time2 = time2.trim();
		try
		{
			Date time1 = new Date();
			return time1.before(dateFormat.parse(time2));
		}
		catch (ParseException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 得到一个完整日期时间的日期毫秒数 
	 */
	public static long getDateMilliSecond(Date date)
	{
		return date.getTime() - getTimeMilliSecond(date);
	}	
	
	/**
	 * 得到一个完整日期时间的时间毫秒数 
	 */
	public static long getTimeMilliSecond(Date date)
	{
		return date.getTime() % (24 * 60 * 60 * 1000);
	}
	
	/**
	 * 转换时间格式为数组
	 */
	public static int[] parseTimeArray(String timeValue)
	{
		int[] timeArray = new int[5];
		StringTokenizer st = new StringTokenizer(timeValue, ",");
		int i = 0;
		while (st.hasMoreTokens())
		{
			timeArray[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		return timeArray;
	}
	
	/**
	 * 转换时间数组为秒
	 */
	public static long parseSecond(int[] timeArray)
	{
		return timeArray[0] * 24 * 60 * 60 + timeArray[1] * 60 * 60 + timeArray[2] * 60 + timeArray[3];
	}
	
	/**
	 * 转换时间数组为毫秒
	 */
	public static long parseMilliSecond(int[] timeArray)
	{
		return parseSecond(timeArray) * 1000 + timeArray[4];
	}
	
	/**
	 * 转化成日期字符串
	 */
	public static String getDateString(long year, long month, long day)
	{
		String yearString = year + "";
		String monthString = null;
		String dayString = null;
		
		if (month < 10)
		{
			monthString = "0" + month;
		}
		else
		{
			monthString = "" + month;
		}
		
		if (day < 10)
		{
			dayString = "0" + day;
		}
		else
		{
			dayString = "" + day;
		}
		return yearString + "-" + monthString + "-" + dayString;
	}
	
	/**
	 * 转化成时间字符串
	 */
	public static String getTimeString(long hour, long minute, long second)
	{
		String hourString = null;
		String minuteString = null;
		String secondString = null;
		
		if (hour < 10)
		{
			hourString = "0" + hour;
		}
		else
		{
			hourString = "" + hour;
		}
		
		if (minute < 10)
		{
			minuteString = "0" + minute;
		}
		else
		{
			minuteString = "" + minute;
		}
		
		if (second < 10)
		{
			secondString = "0" + second;
		}
		else
		{
			secondString = "" + second;
		}
		return hourString + ":" + minuteString + ":" + secondString;
	}
	
	/**
	 * 避免在多线程中应用不安全
	 */
	public static DateFormat getDateTimeFormat()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 避免在多线程中应用不安全
	 */
	public static DateFormat getDateFormat()
	{
		return new SimpleDateFormat("yyyy-MM-dd");
	}
	
	/**
	 * 避免在多线程中应用不安全
	 */
	public static DateFormat getMilliSecondTimeDateFormat()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	}
	
	/**
	 * 避免在多线程中应用不安全
	 */
	public static DateFormat getTimeFormat()
	{
		return new SimpleDateFormat("HH:mm:ss");
	}
	
	/**
	 * 避免在多线程中应用不安全
	 */
	public static DateFormat getMilliSecondTimeFormat()
	{
		return new SimpleDateFormat("HH:mm:ss:SSS");
	}
	
	public static void main(String[] args)
	{		
//		System.out.println("getCurrentYear() : " + getCurrentYear());
//		System.out.println("getCurrentMonth() : " + getCurrentMonth());
//		System.out.println("getCurrentDay() : " + getCurrentDay());
//		System.out.println("getCurrentHour() : " + getCurrentHour());
//		System.out.println("getCurrentMinute() : " + getCurrentMinute());
//		System.out.println("getCurrentSecond() : " + getCurrentSecond());
//		System.out.println("getCurrentMilliSecond() : " + getCurrentMilliSecond());
//		System.out.println("getCurrentDateTime() : " + getCurrentDateTime());
//		System.out.println("getDateTime() : " + getDateTime(new Date()));
//		System.out.println("getCurrentDate() : " + getCurrentDate());
//		System.out.println("getDate() : " + getDate(new Date()));
//		System.out.println("getCurrentTime() : " + getCurrentTime());
//		System.out.println("getTime() : " + getTime(new Date()));
//		System.out.println("getCurrentDayOfWeek() : " + getCurrentDayOfWeek());
//		System.out.println("getDayOfWeek() : " + getDayOfWeek(2010, 3, 9));
//		System.out.println("getCurrentWeekOfMonth() : " + getCurrentWeekOfMonth());
//		System.out.println("getWeekOfMonth() : " + getWeekOfMonth(2209, 4, 9));
//		System.out.println("getCurrentWeekOfYear() : " + getCurrentWeekOfYear());
//		System.out.println("getWeekOfYear() : " + getWeekOfYear(2010, 3, 9));
//		System.out.println("parseDateTime() : " + parseDateTime("2010-01-01 01:01:01"));
//		System.out.println("parseDate() : " + parseDate("2012-02-02"));
//		System.out.println("parseTime() : " + parseTime("02:02:02"));
		
		Date date1 = parseDateTime("2000-10-29 00:59:59");
		System.out.println("Date : " + date1);
		
		int offset1 = getDSTOffset(date1);
		System.out.println("Offset: " + offset1);
		
		Date date2 = parseDateTime("2000-10-29 01:00:00");
		System.out.println("Date : " + date2);
		
		int offset2 = getDSTOffset(date2);
		System.out.println("Offset: " + offset2);
		
//		Date date5 = parseDateTime("2000-10-29 00:59:59:111");
//		String dateString5 = getFormatString(date5, getDateFormat());
//		
//		Date date6 = parseDateTime("2005-11-01 23:00:00:222");
//		String dataString6 = getFormatString(date6, getMilliSecondTimeFormat());
//		
//		Date date7 = parseDateTime(dateString5 + " " + dataString6);
//		System.out.println(date7);
	}
}