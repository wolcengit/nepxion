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

import com.nepxion.swing.renderer.list.ElementListCellRenderer;

public class ElementComboBoxCellRenderer
	extends ElementListCellRenderer
{
	public ElementComboBoxCellRenderer()
	{
		super();
	}
	
	public ElementComboBoxCellRenderer(int fixedCellHeight)
	{
		super(fixedCellHeight);
	}
	
	public ElementComboBoxCellRenderer(Icon cellIcon)
	{
		super(cellIcon);
	}
	
	public ElementComboBoxCellRenderer(Border cellBorder)
	{
		super(cellBorder);
	}
	
	public ElementComboBoxCellRenderer(Icon cellIcon, int fixedCellHeight)
	{
		super(cellIcon, fixedCellHeight);
	}
	
	public ElementComboBoxCellRenderer(Border cellBorder, int fixedCellHeight)
	{
		super(cellBorder, fixedCellHeight);
	}
	
	public ElementComboBoxCellRenderer(Border cellBorder, Icon cellIcon)
	{
		super(cellBorder, cellIcon);
	}
	
	public ElementComboBoxCellRenderer(Border cellBorder, Icon cellIcon, int fixedCellHeight)
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