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

import java.awt.Dimension;
import java.util.Date;

import javax.swing.SpinnerDateModel;

import com.jidesoft.spinner.DateSpinner;

public class JTimeSelector
	extends DateSpinner
{
	public JTimeSelector()
	{
		super("HH:mm:ss");
	}
	
	public JTimeSelector(String format)
	{
		super(format);
	}
	
	public JTimeSelector(String format, Date date)
	{
		super(format, date);
	}
	
	public Date getTime()
	{
		SpinnerDateModel model = (SpinnerDateModel) getModel();
		Object value = model.getValue();
		if (value instanceof Date)
		{
			return (Date) value;
		}
		
		return null;
	}
	
	public void setTime(Date date)
	{
		SpinnerDateModel model = (SpinnerDateModel) getModel();
		model.setValue(date);
	}
	
	public Dimension getPreferredSize()
	{
		Dimension preferredSize = super.getPreferredSize();
		
		return new Dimension(preferredSize.width + 5, preferredSize.height);
	}
}