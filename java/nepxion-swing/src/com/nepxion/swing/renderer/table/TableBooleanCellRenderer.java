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

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.nepxion.swing.locale.SwingLocale;

public class TableBooleanCellRenderer
	extends DefaultTableCellRenderer
{
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if (value != null && value instanceof String)
		{
			String text = "";
			int flag = -1;
			try
			{
				flag = Integer.parseInt(value.toString());
			}
			catch (NumberFormatException e)
			{
				
			}
			if (flag == 0)
			{
				text = SwingLocale.getString("false");
			}
			else if (flag == 1)
			{
				text = SwingLocale.getString("true");
			}
			else
			{
				text = SwingLocale.getString("unknown");
			}
			setText(text);
		}
		
		return this;
	}
}