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

import javax.swing.JSpinner;

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JYearChooser;

public class JYearSelector
	extends JYearChooser
{
	public JYearSelector()
	{
		super();
		
		initComponents();
	}
	
	private void initComponents()
	{
		setFont(FontContext.getFont());
		
		JSpinner spinner = (JSpinner) getSpinner();
		CalendarStyleManager.setPreferenceStyle(spinner);
	}
}