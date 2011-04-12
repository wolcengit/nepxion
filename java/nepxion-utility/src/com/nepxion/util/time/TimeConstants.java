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
import java.text.SimpleDateFormat;

public interface TimeConstants
{
	public final static String DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	public final static String MILLISECOND_DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss:SSS";
	public final static String TIME_ZONE_DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss zzzz";
	public final static String DATE_FORMAT_STRING = "yyyy-MM-dd";
	public final static String TIME_FORMAT_STRING = "HH:mm:ss";
	public final static String MILLISECOND_TIME_FORMAT_STRING = "HH:mm:ss:SSS";
	
	public static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT_STRING);
	public static final DateFormat MILLISECOND_DATE_TIME_FORMAT = new SimpleDateFormat(MILLISECOND_DATE_TIME_FORMAT_STRING);
	public static final DateFormat TIME_ZONE_DATE_TIME_FORMAT = new SimpleDateFormat(TIME_ZONE_DATE_TIME_FORMAT_STRING);
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STRING);
	public static final DateFormat TIME_FORMAT = new SimpleDateFormat(TIME_FORMAT_STRING);
	public static final DateFormat MILLISECOND_TIME_FORMAT = new SimpleDateFormat(MILLISECOND_TIME_FORMAT_STRING);
}