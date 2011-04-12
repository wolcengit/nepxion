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

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import com.nepxion.swing.element.IElementNode;

public class RowHeaderTableCellRenderer
	extends DefaultListCellRenderer
{
	private JTableHeader header;
	
	public RowHeaderTableCellRenderer(JTable table)
	{
		header = table.getTableHeader();
		setOpaque(true);
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		/* setHorizontalAlignment(CENTER); */
		setForeground(header.getForeground());
		setBackground(header.getBackground());
		setFont(header.getFont());
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		IElementNode elementNode = (IElementNode) value;
		setText(elementNode.getText());
		setIcon(elementNode.getIcon());
		setToolTipText(elementNode.getToolTipText());
		
		return this;
	}
}