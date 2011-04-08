package com.nepxion.swing.editor.table;

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
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.nepxion.swing.selector.calendar.JDateTimeSelector;
import com.toedter.calendar.IDateEditor;

public class DateTimeTableCellEditor
	extends AbstractCellEditor implements TableCellEditor
{
	private JDateTimeSelector dateTimeSelector;
	
	public DateTimeTableCellEditor(String dateFormatString, IDateEditor dateEditor)
	{
		dateTimeSelector = new JDateTimeSelector(null, dateFormatString, dateEditor);
	}
	
	public boolean isCellEditable(EventObject e)
	{
		if (e instanceof MouseEvent)
		{
			MouseEvent mouseEvent = (MouseEvent) e;
			
			return mouseEvent.getClickCount() >= 2;
		}
		
		return true;
	}
	
	public Object getCellEditorValue()
	{
		return dateTimeSelector.getDate();
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	{
		dateTimeSelector.setDate((Date) value);
		
		return dateTimeSelector;
	}
}