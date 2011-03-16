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

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JCalendar;

public class JCalendarSelector
	extends JCalendar
{
	public JCalendarSelector()
	{
		super();
		
		initComponents();
	}
	
	public JCalendarSelector(Date date)
	{
		super(date);
		
		initComponents();
	}
	
	public JCalendarSelector(Calendar calendar)
	{
		super(calendar);
		
		initComponents();
	}
	
	public JCalendarSelector(Locale locale)
	{
		super(locale);
		
		initComponents();
	}
	
	public JCalendarSelector(Date date, Locale locale)
	{
		super(date, locale);
		
		initComponents();
	}
	
	public JCalendarSelector(Date date, boolean monthSpinner)
	{
		super(date, monthSpinner);
		
		initComponents();
	}
	
	public JCalendarSelector(Locale locale, boolean monthSpinner)
	{
		super(locale, monthSpinner);
		
		initComponents();
	}
	
	public JCalendarSelector(boolean monthSpinner)
	{
		super(monthSpinner);
		
		initComponents();
	}
	
	public JCalendarSelector(Date date, Locale locale, boolean monthSpinner, boolean weekOfYearVisible)
	{
		super(date, locale, monthSpinner, weekOfYearVisible);
		
		initComponents();
	}
	
	private void initComponents()
	{
		setFont(FontContext.getFont());
				
		JSpinner spinner = (JSpinner) getYearChooser().getSpinner();
		CalendarStyleManager.setPreferenceStyle(spinner);
		
		JComboBox comboBox = (JComboBox) getMonthChooser().getComboBox();
		CalendarStyleManager.setPreferenceStyle(comboBox);
	}
}