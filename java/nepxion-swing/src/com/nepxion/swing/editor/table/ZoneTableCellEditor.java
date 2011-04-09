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

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.nepxion.swing.searcher.zone.local.JZoneSelectorPanel;
import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;

public class ZoneTableCellEditor
	extends AbstractCellEditor implements TableCellEditor
{
	private JZoneSelectorPanel zoneSelectorPanel;
	
	public ZoneTableCellEditor()
	{
		zoneSelectorPanel = new JZoneSelectorPanel(true);
		
		JClassicSelectorMenuButton menuButton = (JClassicSelectorMenuButton) zoneSelectorPanel.getMenuButton();
		menuButton.setShowArrow(false);
	}
	
	public ZoneTableCellEditor(int maximumLength)
	{
		zoneSelectorPanel = new JZoneSelectorPanel(maximumLength, true);
		
		JClassicSelectorMenuButton menuButton = (JClassicSelectorMenuButton) zoneSelectorPanel.getMenuButton();
		menuButton.setShowArrow(false);
	}
	
	public ZoneTableCellEditor(JZoneSelectorPanel zoneSelectorPanel)
	{
		this.zoneSelectorPanel = zoneSelectorPanel;
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
		return zoneSelectorPanel.getValue();
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	{
		zoneSelectorPanel.setValue(value);
		
		return zoneSelectorPanel;
	}
}