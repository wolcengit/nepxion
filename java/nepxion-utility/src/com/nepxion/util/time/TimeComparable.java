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

import java.util.Date;

public class TimeComparable
	implements Comparable, TimeConstants
{
	private Date dateTime;
	private String formatString;
	
	public TimeComparable(Date dateTime)
	{
		this(dateTime, DATE_TIME_FORMAT_STRING);
	}
	
	public TimeComparable(Date dateTime, String formatString)
	{
		this.dateTime = dateTime;
		this.formatString = formatString;
	}
	
	public Date getDateTime()
	{
		return dateTime;
	}
	
	public void setDateTime(Date dateTime)
	{
		this.dateTime = dateTime;
	}
	
	public String getFormatString()
	{
		return formatString;
	}
	
	public void setFormatString(String formatString)
	{
		this.formatString = formatString;
	}
	
	public int compareTo(Object object)
	{
		TimeComparable timeComparable = (TimeComparable) object;
		Date dateTime = timeComparable.getDateTime();
		
		return dateTime.toString().compareTo(dateTime.toString());
	}
	
	public String toString()
	{
		String dateTimeString = null;
		
		if (formatString.equals(DATE_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getDateTime(dateTime);
		}
		else if (formatString.equals(MILLISECOND_DATE_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getMillisecondDateTime(dateTime);
		}
		else if (formatString.equals(TIME_ZONE_DATE_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getTimeZoneDateTime(dateTime);
		}
		else if (formatString.equals(DATE_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getDate(dateTime);
		}
		else if (formatString.equals(TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getTime(dateTime);
		}
		else if (formatString.equals(MILLISECOND_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getMillisecondTime(dateTime);
		}
		
		if (dateTimeString == null)
		{
			dateTimeString = TimeUtil.getDateTime(dateTime);
		}
		
		return dateTimeString;
	}
}