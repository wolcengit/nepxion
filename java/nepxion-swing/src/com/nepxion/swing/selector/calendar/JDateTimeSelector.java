package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Date;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;

public class JDateTimeSelector
	extends JDateSelector
{
	public JDateTimeSelector()
	{
		super();
	}
	
	public JDateTimeSelector(IDateEditor dateEditor)
	{
		super(dateEditor);
	}
	
	public JDateTimeSelector(Date date)
	{
		super(date);
	}
	
	public JDateTimeSelector(Date date, String dateFormatString)
	{
		super(date, dateFormatString);
	}
	
	public JDateTimeSelector(Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(date, dateFormatString, dateEditor);
	}
	
	public JDateTimeSelector(String datePattern, String maskPattern, char placeholder)
	{
		super(datePattern, maskPattern, placeholder);
	}
	
	public JDateTimeSelector(JCalendar calendar, Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(calendar, date, dateFormatString, dateEditor);
	}
}