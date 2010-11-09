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

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JCalendarSelectorOptionPane
	extends JBasicOptionPane implements ICalendarSelectorComponent
{
	private Component parentComponent;
	private JCalendarSelector calendarSelector;
	private JPanel layoutPanel;
	
	public JCalendarSelectorOptionPane(Component parentComponent)
	{
		this.parentComponent = parentComponent;
		
		calendarSelector = new JCalendarSelector();
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(calendarSelector, BorderLayout.NORTH);
	}
	
	public int showCalendarDialog()
	{
		return showDialog(parentComponent, layoutPanel, SwingLocale.getString("calendar_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	public JCalendarSelector getCalendarSelector()
	{
		return calendarSelector;
	}
	
	public void setCalendarSelector(JCalendarSelector calendarSelector)
	{
		this.calendarSelector = calendarSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(calendarSelector);
	}
}