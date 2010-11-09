package com.nepxion.swing.renderer.combobox;

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
import javax.swing.JList;
import javax.swing.border.Border;

import com.nepxion.swing.renderer.list.ListElementCellRenderer;

public class ComboBoxElementCellRenderer
	extends ListElementCellRenderer
{
	public ComboBoxElementCellRenderer()
	{
		super();
	}
	
	public ComboBoxElementCellRenderer(int fixedCellHeight)
	{
		super(fixedCellHeight);
	}
	
	public ComboBoxElementCellRenderer(Icon cellIcon)
	{
		super(cellIcon);
	}
	
	public ComboBoxElementCellRenderer(Border cellBorder)
	{
		super(cellBorder);
	}
	
	public ComboBoxElementCellRenderer(Icon cellIcon, int fixedCellHeight)
	{
		super(cellIcon, fixedCellHeight);
	}
	
	public ComboBoxElementCellRenderer(Border cellBorder, int fixedCellHeight)
	{
		super(cellBorder, fixedCellHeight);
	}
	
	public ComboBoxElementCellRenderer(Border cellBorder, Icon cellIcon)
	{
		super(cellBorder, cellIcon);
	}
	
	public ComboBoxElementCellRenderer(Border cellBorder, Icon cellIcon, int fixedCellHeight)
	{
		super(cellBorder, cellIcon, fixedCellHeight);
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		if (index > -1)
		{
			list.setToolTipText(value.toString());
		}
		return this;
	}
}