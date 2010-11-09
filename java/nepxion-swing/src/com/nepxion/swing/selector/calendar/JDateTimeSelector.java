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

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.util.time.TimeUtil;

public class JDateTimeSelector
	extends JPanel
{
	private JDateSelector dateSelector;
	private JTimeSelector timeSelector;
	
	public JDateTimeSelector()
	{
		dateSelector = new JDateSelector();
		timeSelector = new JTimeSelector();
		
		double[][] size = 
		{ 
			{TableLayout.FILL, TableLayout.PREFERRED}, 
			{TableLayout.FILL}
		};
		
		setLayout(new TableLayout(size));
		add(dateSelector, "0, 0");
		add(timeSelector, "1, 0");
	}
	
	public JDateSelector getDateSelector()
	{
		return dateSelector;
	}
	
	public JTimeSelector getTimeSelector()
	{
		return timeSelector;
	}
	
	public Date getDate()
	{
		String dateString = TimeUtil.getFormatString(dateSelector.getDate(), new SimpleDateFormat(dateSelector.getFormat()));
		String timeString = TimeUtil.getFormatString(timeSelector.getTime(), new SimpleDateFormat(timeSelector.getFormat()));
		Date date = TimeUtil.parseFormatDate(dateString + " " + timeString, new SimpleDateFormat(dateSelector.getFormat() + " " + timeSelector.getFormat()));
		return date;
	}
	
	public void setDate(Date date)
	{
		String dateString = TimeUtil.getDate(date);
		String timeString = TimeUtil.getTime(date);
		dateSelector.setDate(TimeUtil.parseDate(dateString));
		timeSelector.setTime(TimeUtil.parseTime(timeString));
	}
	
	public void setFormat(String dateFormat, String timeFormat)
	{
		dateSelector.setFormat(dateFormat);
		timeSelector.setFormat(timeFormat);
	}
}