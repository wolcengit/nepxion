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
	private String format;
	
	public TimeComparable(Date dateTime)
	{
		this(dateTime, DATE_TIME_FORMAT);
	}
	
	public TimeComparable(Date dateTime, String format)
	{
		this.dateTime = dateTime;
		this.format = format;
	}
	
	public Date getDateTime()
	{
		return dateTime;
	}
	
	public void setDateTime(Date dateTime)
	{
		this.dateTime = dateTime;
	}
	
	public String getFormat()
	{
		return format;
	}
	
	public void setFormat(String format)
	{
		this.format = format;
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
		
		if (format.equals(DATE_TIME_FORMAT))
		{
			dateTimeString = TimeUtil.getDateTime(dateTime);
		}
		else if (format.equals(MILLISECOND_DATE_TIME_FORMAT))
		{
			dateTimeString = TimeUtil.getMillisecondDateTime(dateTime);
		}
		else if (format.equals(TIME_ZONE_DATE_TIME_FORMAT))
		{
			dateTimeString = TimeUtil.getTimeZoneDateTime(dateTime);
		}
		else if (format.equals(DATE_FORMAT))
		{
			dateTimeString = TimeUtil.getDate(dateTime);
		}
		else if (format.equals(TIME_FORMAT))
		{
			dateTimeString = TimeUtil.getTime(dateTime);
		}
		else if (format.equals(MILLISECOND_TIME_FORMAT))
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