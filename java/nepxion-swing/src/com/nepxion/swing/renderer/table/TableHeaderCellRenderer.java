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

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.nepxion.swing.element.IElementNode;

public class TableHeaderCellRenderer
	extends JLabel implements TableCellRenderer
{	
	public TableHeaderCellRenderer(JTableHeader header, IElementNode elementNode, int cellAlignment)
	{		
		setForeground(header.getForeground());
		setBackground(header.getBackground());
		setFont(header.getFont());
		
		setText(elementNode.getText());
		setIcon(elementNode.getIcon());
		setToolTipText(elementNode.getToolTipText());
		
		setHorizontalAlignment(cellAlignment);
		setOpaque(true);
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		return this;
	}
}