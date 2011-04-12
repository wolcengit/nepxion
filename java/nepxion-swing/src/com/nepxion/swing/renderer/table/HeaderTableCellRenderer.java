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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.nepxion.swing.element.IElementNode;

public class HeaderTableCellRenderer
	extends DefaultTableCellRenderer
{	
	public HeaderTableCellRenderer(JTableHeader header, IElementNode elementNode)
	{		
		setForeground(header.getForeground());
		setBackground(header.getBackground());
		setFont(header.getFont());
		
		setText(elementNode.getText());
		setIcon(elementNode.getIcon());
		setToolTipText(elementNode.getToolTipText());
		
		setOpaque(true);
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		return this;
	}
}