package com.nepxion.swing.renderer.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.nepxion.util.time.TimeUtil;

public class DateTimeTableCellRenderer
	extends DefaultTableCellRenderer
{
	private DateFormat dataFormat;
	
	public DateTimeTableCellRenderer()
	{
		setOpaque(true);
	}
	
	public DateTimeTableCellRenderer(DateFormat dataFormat)
	{
		this.dataFormat = dataFormat;
		
		setOpaque(true);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if (value instanceof Date)
		{
			Date date = (Date) value;
			String text = TimeUtil.getFormatString(date, dataFormat);
			
			setText(text);
		}
		
		return this;
	}
}