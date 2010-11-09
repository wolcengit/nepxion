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

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.icon.paint.GeoCellIcon;

public class TableGeoCellRenderer
	extends JLabel implements TableCellRenderer
{
	public TableGeoCellRenderer()
	{
		setOpaque(true);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		IElementNode elementNode = (IElementNode) value;
		Color color = (Color) elementNode.getUserObject();
		setIcon(new GeoCellIcon(elementNode.getIndex(), color));
		setFont(table.getFont());
		setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
		setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
		return this;
	}
}