package com.nepxion.util.time;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

import com.nepxion.util.locale.UtilityLocale;

public class TimeUtil
	implements TimeConstants
{
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
	private static SimpleDateFormat millisecondDateTimeFormat = new SimpleDateFormat(MILLISECOND_DATE_TIME_FORMAT);
	private static SimpleDateFormat timeZoneDateTimeFormat = new SimpleDateFormat(TIME_ZONE_DATE_TIME_FORMAT);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
	private static SimpleDateFormat millisecondTimeFormat = new SimpleDateFormat(MILLISECOND_TIME_FORMAT);
	
	/**
	 * Get the current year
	 * @return  the current year
	 */
	public static int getCurrentYear()
	{
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * Get the current month
	 * @return  the current month
	 */
	public static int getCurrentMonth()
	{
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Get the current day
	 * @return  the current day
	 */
	public static int getCurrentDay()
	{
		return Calendar.getInstance().get(Calendar.DATE);
	}
	
	/**
	 * Get the current hour
	 * @return  the current hour
	 */
	public static int getCurrentHour()
	{
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Get the current minute
	 * @return  the current minute
	 */
	public static int getCurrentMinute()
	{
		return Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	/**
	 * Get the current second
	 * @return  the current second
	 */
	public static int getCurrentSecond()
	{
		return Calendar.getInstance().get(Calendar.SECOND);
	}
	
	/**
	 * Get the current millisecond
	 * @return  the current millisecond
	 */
	public static int getCurrentMillisecond()
	{
		return Calendar.getInstance().get(Calendar.MILLISECOND);
	}
	
	/**
	 * Get the current date and time string.Its format string is yyyy-MM-dd HH:mm:ss
	 * @return  the current date and time string
	 */
	public static String getCurrentDateTime()
	{
		return getDateTime(new Date());
	}
		
	/**
	 * Get a date and time string.Its format string is yyyy-MM-dd HH:mm:ss
	 * @param date  the instance of Date
	 * @return      a date and time string 
	 */
	public static String getDateTime(Date date)
	{
		return getFormatString(date, getDateTimeFormat());
	}
	
	/**
	 * Get a date and time string.Its format string is yyyy-MM-dd HH:mm:ss:SSS
	 * @param date  the instance of Date
	 * @return      a date and time string 
	 */
	public static String getMillisecondDateTime(Date date)
	{
		return getFormatString(date, getMillisecondDateTimeFormat());
	}
	
	/**
	 * Get a date and time string.Its format string is yyyy-MM-dd HH:mm:ss zzzz
	 * @param date  the instance of Date
	 * @return      a date and time string 
	 */
	public static String getTimeZoneDateTime(Date date)
	{
		return getFormatString(date, getTimeZoneDateTimeFormat());
	}
	
	/**
	 * Get the current date string.Its format string is yyyy-MM-dd
	 * @return  the current date string
	 */	
	public static String getCurrentDate()
	{
		return getDate(new Date());
	}
	
	/**
	 * Get a date string.Its format string is yyyy-MM-dd
	 * @param date  the instance of Date
	 * @return      a date string
	 */
	public static String getDate(Date date)
	{
		return getFormatString(date, getDateFormat());
	}
	
	/** 
	 * Get the current time string.Its format string is HH:mm:ss
	 * @return the current time string
	 */
	public static String getCurrentTime()
	{
		return getTime(new Date());
	}
	
	/**
	 * Get a time string.Its format string is HH:mm:ss
	 * @param date  the instance of Date
	 * @return      a time string
	 */
	public static String getTime(Date date)
	{
		return getFormatString(date, getTimeFormat());
	}
	
	/** 
	 * Get the current millisecond time string.Its format string is HH:mm:ss:SSS
	 * @return the current millisecond time string
	 */
	public static String getCurrentMillisecondTime()
	{
		return getMillisecondTime(new Date());
	}
	
	/**
	 * Get a time millisecond string.Its format string is HH:mm:ss:SSS
	 * @param date  the instance of Date
	 * @return      a millisecond time string
	 */
	public static String getMillisecondTime(Date date)
	{		
		return getFormatString(date, getMillisecondTimeFormat());
	}	
		
	/**
	 * Get the common format string
	 * @param date        the instanceof Date 
	 * @param dateFormat  the instanceof DateFormat
	 * @return            the format string     
	 */
	public static String getFormatString(Date date, DateFormat dateFormat)
	{
		return dateFormat.format(date);
	}
	
	/**
	 * Get the current day of the week
	 * @return  the current day of the week
	 */
	public static int getCurrentDayOfWeek()
	{
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Get a day of the week 
	 * @param year   the year
	 * @param month  the month
	 * @param day    the day
	 * @return       a day of the week
	 */
	public static int getDayOfWeek(int year, int month, int day)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Get the current week of the month
	 * @return  the current week of the month
	 */
	public static int getCurrentWeekOfMonth()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * Get a week of the month
	 * @param year   the year
	 * @param month  the month
	 * @param day    the day
	 * @return       a week of the month
	 */
	public static int getWeekOfMonth(int year, int month, int day)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * Get the current week of the year
	 * @return  the current week of the year
	 */
	public static int getCurrentWeekOfYear()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * Get a week of the year
	 * @param year   the year
	 * @param month  the month
	 * @param day    the day
	 * @return       a week of the year
	 */
	public static int getWeekOfYear(int year, int month, int day)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * Parse string to date instance.Its format is yyyy-MM-dd HH:mm:ss
	 * @param date  the date string
	 * @return      the instance of Date
	 */
	public static Date parseDateTime(String date)
	{
		return parseFormatDate(date, getDateTimeFormat());
	}
	
	/**
	 * Parse string to date instance.Its format is yyyy-MM-dd HH:mm:ss zzzz
	 * @param date  the date string
	 * @return      the instance of Date
	 */
	public static Date parseTimeZoneDateTime(String date)
	{
		return parseFormatDate(date, getTimeZoneDateTimeFormat());
	}

	/**
	 * Parse string to date instance.Its format is yyyy-MM-dd
	 * @param date  the date string
	 * @return      the instance of Date
	 */	
	public static Date parseDate(String date)
	{
		return parseFormatDate(date, getDateFormat());
	}
	
	/**
	 * Parse String to date instance.Its format is HH:mm:ss
	 * @param time  the time string
	 * @return      the instance of Date
	 */		
	public static Date parseTime(String time)
	{
		return parseFormatDate(time, getTimeFormat());
	}
	
	/**
	 * Parse String to the common format Date
	 * @param dateString  the date string
	 * @param dateFormat  the instance of DateFormat
	 * @return            the instance of Date
	 */
	public static Date parseFormatDate(String dateString, DateFormat dateFormat)
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
	 * Get the calendar instance
	 * @param dateTime  the date time string
	 * @return          the instance of GregorianCalendar
	 */
	public static GregorianCalendar getCalendar(String dateTime)
	{
		GregorianCalendar gc = new GregorianCalendar();
		Date date = parseDateTime(dateTime);
		gc.setTime(date);
		return gc;
	}

	/**
	 * Get the daylight saving time offset
	 * @param date  the instance of Date
	 * @return      the daylight saving time offset
	 */
	public static int getDSTOffset(Date date)
	{
		return getDSTOffset(date, TimeZone.getDefault());
	}
	
	/**
	 * Get the daylight saving time offset
	 * @param date      the instance of Date
	 * @param timeZone  the instance of TimeZone
	 * @return          the daylight saving time offset
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
	 * Get time interval String.Its format is "HH:mm:ss"
	 * @param startMillisecond  the start millisecond
	 * @param endMillisecond    the end millisecond
	 * @return                  time interval String
	 */
	public static String getTimeInterval(long startMillisecond, long endMillisecond)
	{
		long second = Math.abs(startMillisecond - endMillisecond) / 1000;
		
		long hour = second / 3600;
		second = second - (hour * 3600);
		
		long minute = second / 60;
		second = second - (minute * 60);
		
		return getTimeString(hour, minute, second);
	}
	
	/**
	 * Get millisecond time interval String.Its format is "HH:mm:ss:SSS"
	 * @param startMillisecond  the start millisecond
	 * @param endMillisecond    the end millisecond
	 * @return                  millisecond time interval String
	 */
	public static String getMillisecondTimeInterval(long startMillisecond, long endMillisecond)
	{
		long millisecond = Math.abs(startMillisecond - endMillisecond);
		
		long hour = millisecond / 3600000;
		millisecond = millisecond - (hour * 3600000);
		
		long minute = millisecond / 60000;
		millisecond = millisecond - (minute * 60000);
		
		long second = millisecond / 1000;
		millisecond = millisecond - (second * 1000);
		
		return getMillisecondTimeString(hour, minute, second, millisecond);
	}	
	
	/**
	 * Judge whether time1 is before time2.Its format is yyyy-MM-dd HH:mm:ss
	 * @param time1  the inputting time1
	 * @param time2  the inputting time2
	 * @return       boolean flag
	 */
	public static boolean isTimeBefore(String time1, String time2)
	{
		return isTimeBefore(time1, time2, getDateTimeFormat());
	}
	
	/**
	 * Judge whether time1 is before time2
	 * @param time1       the inputting time1
	 * @param time2       the inputting time2
	 * @param dateFormat  the instance of DateFormat
	 * @return            boolean flag
	 */
	public static boolean isTimeBefore(String time1, String time2, DateFormat dateFormat)
	{
		time1 = time1.trim();
		time2 = time2.trim();
		try
		{
			return dateFormat.parse(time1).before(dateFormat.parse(time2));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Judge whether inputting time is before current time.Its format is yyyy-MM-dd HH:mm:ss
	 * @param time  the inputting time
	 * @return      boolean flag
	 */
	public static boolean isTimeBefore(String time)
	{
		return isTimeBefore(time, getDateTimeFormat());
	}
	
	/**
	 * Judge whether inputting time is before current time
	 * @param time        the inputting time
	 * @param dateFormat  the instance of DateFormat
	 * @return            boolean flag
	 */
	public static boolean isTimeBefore(String time, DateFormat dateFormat)
	{
		time = time.trim();
		try
		{
			Date currentTime = new Date();
			return dateFormat.parse(time).before(currentTime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Judge whether time1 is after time2.Its format is yyyy-MM-dd HH:mm:ss
	 * @param time1  the inputting time1
	 * @param time2  the inputting time2
	 * @return       boolean flag
	 */
	public static boolean isTimeAfter(String time1, String time2)
	{
		return isTimeAfter(time1, time2, getDateTimeFormat());
	}
	
	/**
	 * Judge whether time1 is after time2
	 * @param time1       the inputting time1
	 * @param time2       the inputting time2
	 * @param dateFormat  the instance of DateFormat
	 * @return            boolean flag
	 */
	public static boolean isTimeAfter(String time1, String time2, DateFormat dateFormat)
	{
		time1 = time1.trim();
		time2 = time2.trim();
		try
		{
			return dateFormat.parse(time1).after(dateFormat.parse(time2));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Judge whether inputting time is after current time.Its format is yyyy-MM-dd HH:mm:ss
	 * @param time  the inputting time
	 * @return      boolean flag
	 */
	public static boolean isTimeAfter(String time)
	{
		return isTimeAfter(time, getDateTimeFormat());
	}
	
	/**
	 * Judge whether inputting time is after current time
	 * @param time        the inputting time
	 * @param dateFormat  the instance of DateFormat
	 * @return            boolean flag
	 */
	public static boolean isTimeAfter(String time, DateFormat dateFormat)
	{
		time = time.trim();
		try
		{
			Date currentTime = new Date();
			return dateFormat.parse(time).after(currentTime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return false;
		}
	}	
	
	/**
	 * Get the date millisecond
	 * @param date  the instance of Date
	 * @return      
	 */
	public static long getDateMillisecond(Date date)
	{
		return date.getTime() - getTimeMillisecond(date);
	}
	
	/**
	 * Get the time millisecond
	 * @param date  the instance of Date
	 * @return      the millisecond
	 */
	public static long getTimeMillisecond(Date date)
	{
		return date.getTime() % (24 * 60 * 60 * 1000);
	}
	
	/**
	 * Get the second
	 * @param timeArray  the time array.Its format is {day, hour, minute, second}
	 * @return           the second
	 */
	public static long getSecond(int[] timeArray)
	{
		return timeArray[0] * 24 * 60 * 60 + timeArray[1] * 60 * 60 + timeArray[2] * 60 + timeArray[3];
	}
	
	/**
	 * Get the milliSecond
	 * @param timeArray  the time array.Its format is {day, hour, minute, second, milliSecond}
	 * @return           the milliSecond
	 */
	public static long getMillisecond(int[] timeArray)
	{
		return getSecond(timeArray) * 1000 + timeArray[4];
	}
	
	/**
	 * Get the time array
	 * @param timeString  the time string.Its format is example "day, hour, minute, second"
	 * @param delimiter   the time delimiter, example ", "
	 * @return            the time array
	 */
	public static int[] parseTimeArray(String timeString, String delimiter)
	{
		int[] timeArray = new int[4];
		StringTokenizer st = new StringTokenizer(timeString, delimiter);
		int i = 0;
		while (st.hasMoreTokens())
		{
			timeArray[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		return timeArray;
	}		
	
	/**
	 * Get the millisecond time array
	 * @param timeString  the time string.Its format is example "day, hour, minute ,second, milliSecond"
	 * @param delimiter   the time delimiter, example ", "
	 * @return            the millisecond time array
	 */
	public static int[] parseMillisecondTimeArray(String timeString, String delimiter)
	{
		int[] timeArray = new int[5];
		StringTokenizer st = new StringTokenizer(timeString, delimiter);
		int i = 0;
		while (st.hasMoreTokens())
		{
			timeArray[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		return timeArray;
	}	
	
	/**
	 * Get the date string
	 * @param year   the year
	 * @param month  the month
	 * @param day    the day
	 * @return       the date string
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
	 * Get the time string
	 * @param hour    the hour
	 * @param minute  the minute
	 * @param second  the second
	 * @return        the time string
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
	 * Get the millisecond time string
	 * @param hour         the hour
	 * @param minute       the minute
	 * @param second       the second
	 * @param millisecond  the millisecond
	 * @return             the millisecond time string
	 */
	public static String getMillisecondTimeString(long hour, long minute, long second, long millisecond)
	{
		String hourString = null;
		String minuteString = null;
		String secondString = null;
		String millisecondString = null;
		
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
		
		if (millisecond < 10)
		{
			millisecondString = "00" + millisecond;
		}
		else if (millisecond < 100)
		{
			millisecondString = "0" + millisecond;
		}	
		else 
		{
			millisecondString = "" + millisecond;
		}		
		return hourString + ":" + minuteString + ":" + secondString + ":" + millisecondString;
	}	
	
	/**
	 * Get the date time format
	 * @return  the instance of DateFormat
	 */		
	public synchronized static DateFormat getDateTimeFormat()
	{
		return dateTimeFormat;
	}
	
	/**
	 * Get the millisecond date time format
	 * @return  the instance of DateFormat
	 */	
	public synchronized static DateFormat getMillisecondDateTimeFormat()
	{
		return millisecondDateTimeFormat;
	}
	
	/**
	 * Get the time zone date time format
	 * @return  the instance of DateFormat
	 */		
	public synchronized static DateFormat getTimeZoneDateTimeFormat()
	{
		return timeZoneDateTimeFormat;
	}
		
	/**
	 * Get the date format
	 * @return  the instance of DateFormat
	 */	
	public synchronized static DateFormat getDateFormat()
	{
		return dateFormat;
	}
	
	/**
	 * Get the time format
	 * @return  the instance of DateFormat
	 */	
	public synchronized static DateFormat getTimeFormat()
	{
		return timeFormat;
	}	
	
	/**
	 * Get the millisecond time format
	 * @return  the instance of DateFormat
	 */
	public synchronized static DateFormat getMillisecondTimeFormat()
	{
		return millisecondTimeFormat;
	}
	
	/**
	 * Calculate date time
	 * @param date    the src date time
	 * @param field   the calendar field
	 * @param amount  the amount of date or time to be added to the field
	 * @return        the dest date
	 */
	public static Date calculateDateTime(Date dateTime, int field, int amount)
	{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        calendar.add(field, amount);
        return calendar.getTime();
	}
	
	/**
	 * Delimit date time
	 * @param startDateTime    the start date time
	 * @param endDateTime      the end date time
	 * @param delimitedSecond  the delimited second
	 * @return                 the instance of List
	 * @throws IllegalArgumentException
	 */
	public static List delimitDateTime(Date startDateTime, Date endDateTime, int delimitedSecond)
		throws IllegalArgumentException
	{
		long interval = endDateTime.getTime() - startDateTime.getTime();
		long delimitedMillisecond = delimitedSecond * 1000;
		
		if (interval < delimitedMillisecond)
		{
			throw new IllegalArgumentException(UtilityLocale.getString("interval_not_less_than_delimited_time"));
		}
		
		int splitCount = (int) (interval / delimitedMillisecond);
		
		List dateTimes = new ArrayList();
		dateTimes.add(startDateTime);
		
		for (int i = 0; i < splitCount; i++)
		{
			Date lastDateTime = (Date) dateTimes.get(dateTimes.size() - 1);
			Date dateTime = new Date(lastDateTime.getTime() + delimitedMillisecond);
			dateTimes.add(dateTime);
		}
		
		Date lastDateTime = (Date) dateTimes.get(dateTimes.size() - 1);
		
		if (lastDateTime.getTime() < endDateTime.getTime())
		{
			Date dateTime = new Date(lastDateTime.getTime() + delimitedMillisecond);
			dateTimes.add(dateTime);
		}
		
		return dateTimes;
	}
	
	/**
	 * Get the rang date times
	 * @param dateTimes  the all range date time list
	 * @param dateTime   the date time
	 * @return           the range date time list
	 */
	public static Date[] getRangeDateTimes(List dateTimes, Date dateTime)
	{
		for (int i = 0; i < dateTimes.size() - 1; i++)
		{
			Date dateTime1 = (Date) dateTimes.get(i);
			Date dateTime2 = (Date) dateTimes.get(i + 1);
			
			long time = dateTime.getTime();
			long time1 = dateTime1.getTime();
			long time2 = dateTime2.getTime();
			
			if (time >= time1 && time <= time2)
			{
				return new Date[] {dateTime1, dateTime2};
			}	
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
//		System.out.println("getCurrentYear() : " + getCurrentYear());
//		System.out.println("getCurrentMonth() : " + getCurrentMonth());
//		System.out.println("getCurrentDay() : " + getCurrentDay());
//		System.out.println("getCurrentHour() : " + getCurrentHour());
//		System.out.println("getCurrentMinute() : " + getCurrentMinute());
//		System.out.println("getCurrentSecond() : " + getCurrentSecond());
//		System.out.println("getCurrentMillisecond() : " + getCurrentMillisecond());
		
//		System.out.println("getCurrentDateTime() : " + getCurrentDateTime());
//		System.out.println("getDateTime() : " + getDateTime(new Date()));
		
//		System.out.println("getCurrentDate() : " + getCurrentDate());
//		System.out.println("getDate() : " + getDate(new Date()));
		
//		System.out.println("getCurrentTime() : " + getCurrentTime());
//		System.out.println("getTime() : " + getTime(new Date()));
		
//		System.out.println("getCurrentMillisecondTime() : " + getCurrentMillisecondTime());
//		System.out.println("getMillisecondTime() : " + getMillisecondTime(new Date()));
		
//		System.out.println("getCurrentDayOfWeek() : " + getCurrentDayOfWeek());
//		System.out.println("getDayOfWeek() : " + getDayOfWeek(2010, 3, 9));
//		System.out.println("getCurrentWeekOfMonth() : " + getCurrentWeekOfMonth());
//		System.out.println("getWeekOfMonth() : " + getWeekOfMonth(2209, 4, 9));
//		System.out.println("getCurrentWeekOfYear() : " + getCurrentWeekOfYear());
//		System.out.println("getWeekOfYear() : " + getWeekOfYear(2010, 3, 9));

//		System.out.println("parseDateTime() : " + parseDateTime("2009-03-08 02:30:00"));
//		System.out.println("parseTimeZoneDateTime() : " + parseTimeZoneDateTime("2009-03-08 02:30:00 CDT"));
//		System.out.println("parseTimeZoneDateTime() : " + parseTimeZoneDateTime("2009-03-08 02:30:00 CST"));		
//		System.out.println("parseDate() : " + parseDate("2012-02-02"));
//		System.out.println("parseTime() : " + parseTime("02:02:02"));
	
//		Date date1 = parseDateTime("2000-10-29 00:59:59:111");
//		String dateString1 = getFormatString(date1, getDateFormat());
		
//		Date date2 = parseDateTime("2005-11-01 23:00:00:222");
//		String dataString2 = getFormatString(date2, getMillisecondTimeFormat());
	
//		Date date3 = parseDateTime(dateString1 + " " + dataString2);
//		System.out.println(date3);
					
//		Date date4 = parseDateTime("2000-10-29 00:59:59");
//		System.out.println("Date : " + date4);
		
//		int offset1 = getDSTOffset(date4);
//		System.out.println("Offset: " + offset1);
		
//		Date date5 = parseDateTime("2000-10-29 01:00:00");
//		System.out.println("Date : " + date5);
		
//		int offset2 = getDSTOffset(date5);
//		System.out.println("Offset: " + offset2);

//		System.out.println("getTimeInterval() : " + getTimeInterval(1000000, 2030500));
//		System.out.println("getMillisecondTimeInterval() : " + getMillisecondTimeInterval(1000000, 2030500));
		
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:00", "2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:02", "2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01", "2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:110", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:112", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:111", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));		
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:110", getMillisecondTimeDateFormat()));
//		
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:00", "2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:02", "2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01", "2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:110", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:112", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:111", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));		
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:110", getMillisecondTimeDateFormat()));		
		
//		System.out.println("getDateMillisecond() : " + getDateMillisecond(new Date()));
//		System.out.println("getTimeMillisecond() : " + getTimeMillisecond(new Date()));
	
//		System.out.println("getSecond() : " + getSecond(new int[] {1, 1, 1, 1}));
//		System.out.println("getMillisecond() : " + getMillisecond(new int[] {1, 1, 1, 1, 1}));
		
//		System.out.println("parseTimeArray() : " + parseTimeArray("1, 2, 3, 4", ", ")[0]);
//		System.out.println("parseMillisecondTimeArray() : " + parseMillisecondTimeArray("1| 2| 3| 4| 5", "| ")[1]);
		
//		System.out.println("getDateString() : " + getDateString(2010, 2, 3));
//		System.out.println("getTimeString() : " + getTimeString(1, 2, 3));
//		System.out.println("getMillisecondTimeString() : " + getMillisecondTimeString(1, 2, 3, 4));		
	}
}