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

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.nepxion.swing.element.IElementNode;

public class TableElementCellRenderer
	extends DefaultTableCellRenderer
{
	private Icon cellIcon;
	
	private int cellHeight = -1;
	
	public TableElementCellRenderer()
	{
		this(null);
	}
	
	public TableElementCellRenderer(int cellHeight)
	{
		this(null, cellHeight);
	}
	
	public TableElementCellRenderer(Icon cellIcon)
	{
		this(cellIcon, -1);
	}
	
	public TableElementCellRenderer(Icon cellIcon, int cellHeight)
	{
		this.cellIcon = cellIcon;
		this.cellHeight = cellHeight;
		
		setOpaque(true);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if (cellHeight > 0 && table.getRowHeight() != cellHeight)
		{
			table.setRowHeight(cellHeight);
		}
		if (value instanceof IElementNode)
		{
			IElementNode elementNode = (IElementNode) value;
			setText(elementNode.getText());
			setIcon(elementNode.getIcon());
			setToolTipText(elementNode.getToolTipText());
		}
		else if (value instanceof Icon)
		{
			setText("");
			setIcon((Icon) value);
		}
		else
		{
			setText("");
			if (cellIcon != null)
			{
				setIcon(cellIcon);
			}
		}
		
		return this;
	}
}