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

import com.nepxion.swing.border.LineBorder;

public class TableColorCellRenderer
	extends JLabel implements TableCellRenderer
{
	public TableColorCellRenderer(int cellAlignment)
	{
		setHorizontalAlignment(cellAlignment);
		setOpaque(true);
		setBorder(new LineBorder(Color.black));
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		Color color = (Color) value;
		setBackground(color);
		setFont(table.getFont());
		setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
		
		return this;
	}
}