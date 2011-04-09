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
import java.util.EventObject;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelectorBar;

public class CheckBoxTableCellEditor
	extends AbstractCellEditor implements TableCellEditor
{
	private JCheckBoxSelectorBar checkBoxSelectorBar;
	
	public CheckBoxTableCellEditor(List allElementNodes)
	{
		checkBoxSelectorBar = new JCheckBoxSelectorBar(allElementNodes, true);

		JClassicSelectorMenuButton menuButton = (JClassicSelectorMenuButton) checkBoxSelectorBar.getMenuButton();
		menuButton.setShowArrow(false);
	}
	
	public CheckBoxTableCellEditor(JCheckBoxSelectorBar checkBoxSelectorBar)
	{
		this.checkBoxSelectorBar = checkBoxSelectorBar;
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
		return checkBoxSelectorBar.getValue();
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	{
		checkBoxSelectorBar.setValue(value);
		
		return checkBoxSelectorBar;
	}
}