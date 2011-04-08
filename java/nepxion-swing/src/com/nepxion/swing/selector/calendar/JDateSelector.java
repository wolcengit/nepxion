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

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.popupmenu.PopupMenuManager;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class JDateSelector
	extends JDateChooser
{
	public JDateSelector()
	{
		super();
		
		initComponents();
	}
	
	public JDateSelector(IDateEditor dateEditor)
	{
		super(dateEditor);
		
		initComponents();
	}
	
	public JDateSelector(Date date)
	{
		super(date);
		
		initComponents();
	}
	
	public JDateSelector(Date date, String dateFormatString)
	{
		super(date, dateFormatString);
		
		initComponents();
	}
	
	public JDateSelector(Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(date, dateFormatString, dateEditor);
		
		initComponents();
	}
	
	public JDateSelector(String datePattern, String maskPattern, char placeholder)
	{
		super(datePattern, maskPattern, placeholder);
		
		initComponents();
	}
	
	public JDateSelector(JCalendar calendar, Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(calendar, date, dateFormatString, dateEditor);
		
		initComponents();
	}
	
	private void initComponents()
	{
		setFont(FontContext.getFont());
		
		JButton calendarButton = getCalendarButton();
		
		Icon calendarIcon = IconFactory.getSwingIcon("date.png");
		calendarButton.setIcon(calendarIcon);
		calendarButton.setToolTipText(SwingLocale.getString("select_date_time"));
		
		CalendarManager.setPreferenceStyle(calendarButton);
		
		JSpinner spinner = (JSpinner) getJCalendar().getYearChooser().getSpinner();
		CalendarManager.setPreferenceStyle(spinner);
		
		JComboBox comboBox = (JComboBox) getJCalendar().getMonthChooser().getComboBox();
		CalendarManager.setPreferenceStyle(comboBox);
		
		PopupMenuManager.setPreferenceStyle(popup);
	}
}