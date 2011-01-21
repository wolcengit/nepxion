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

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JDayChooser;

public class JDaySelector
	extends JDayChooser
{
	public JDaySelector()
	{
		super();
		
		initComponents();
	}
	
	public JDaySelector(boolean weekOfYearVisible)
	{
		super(weekOfYearVisible);
		
		initComponents();
	}
	
	private void initComponents()
	{
		setFont(FontContext.getFont());
	}
}