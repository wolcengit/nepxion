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

import javax.swing.JComboBox;

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JMonthChooser;

public class JMonthSelector
	extends JMonthChooser
{
	public JMonthSelector()
	{
		super();
		
		initComponents();
	}
	
	public JMonthSelector(boolean hasSpinner)
	{
		super(hasSpinner);
		
		initComponents();
	}
	
	private void initComponents()
	{
		setFont(FontContext.getFont());
		
		JComboBox comboBox = (JComboBox) getComboBox();
		CalendarManager.setPreferenceStyle(comboBox);
	}
}