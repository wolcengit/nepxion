package com.nepxion.swing.renderer.list;

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

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.border.Border;

import com.nepxion.swing.element.IElementNode;

public class ElementListCellRenderer
	extends DefaultListCellRenderer
{
	private JList list;
	
	private Border noFocusBorder;
	private Border selectionBorder;
	private Border unSeletionBorder;
	
	private Border cellBorder;
	
	private Icon cellIcon;
	
	private int cellHeight = -1;
	
	public ElementListCellRenderer()
	{
		this((Border) null);
	}
	
	public ElementListCellRenderer(int cellHeight)
	{
		this((Border) null, cellHeight);
	}
	
	public ElementListCellRenderer(Icon cellIcon)
	{
		this((Border) null, cellIcon);
	}
	
	public ElementListCellRenderer(Border cellBorder)
	{
		this(cellBorder, null);
	}
	
	public ElementListCellRenderer(JList list)
	{
		this(list, (Border) null);
	}
	
	public ElementListCellRenderer(Icon cellIcon, int cellHeight)
	{
		this((Border) null, cellIcon, cellHeight);
	}
	
	public ElementListCellRenderer(Border cellBorder, int cellHeight)
	{
		this(cellBorder, null, cellHeight);
	}
	
	public ElementListCellRenderer(Border cellBorder, Icon cellIcon)
	{
		this(cellBorder, cellIcon, -1);
	}
	
	public ElementListCellRenderer(JList list, int cellHeight)
	{
		this(list, (Border) null, cellHeight);
	}
	
	public ElementListCellRenderer(JList list, Icon cellIcon)
	{
		this(list, null, cellIcon);
	}
	
	public ElementListCellRenderer(JList list, Border cellBorder)
	{
		this(list, cellBorder, null);
	}
	
	public ElementListCellRenderer(Border cellBorder, Icon cellIcon, int cellHeight)
	{
		this(null, cellBorder, cellIcon, cellHeight);
	}
	
	public ElementListCellRenderer(JList list, Icon cellIcon, int cellHeight)
	{
		this(list, null, cellIcon, cellHeight);
	}
	
	public ElementListCellRenderer(JList list, Border cellBorder, int cellHeight)
	{
		this(list, cellBorder, null, cellHeight);
	}
	
	public ElementListCellRenderer(JList list, Border cellBorder, Icon cellIcon)
	{
		this(list, cellBorder, cellIcon, -1);
	}
	
	public ElementListCellRenderer(JList list, Border cellBorder, Icon cellIcon, int cellHeight)
	{
		this.list = list;
		this.cellBorder = cellBorder;
		this.cellIcon = cellIcon;
		this.cellHeight = cellHeight;
		
		if (list != null && cellHeight > 0)
		{
			list.setFixedCellHeight(cellHeight);
		}
		setOpaque(true);
	}
	
	public JList getList()
	{
		return list;
	}
	
	public void setList(JList list)
	{
		this.list = list;
	}
	
	public Border getCellBorder()
	{
		return cellBorder;
	}
	
	public void setCellBorder(Border cellBorder)
	{
		this.cellBorder = cellBorder;
	}
	
	public Icon getCellIcon()
	{
		return cellIcon;
	}
	
	public void setCellIcon(Icon cellIcon)
	{
		this.cellIcon = cellIcon;
	}
	
	public int getCellHeight()
	{
		return cellHeight;
	}
	
	public void setCellHeight(int cellHeight)
	{
		this.cellHeight = cellHeight;
		
		if (list != null && cellHeight > 0)
		{
			list.setFixedCellHeight(cellHeight);
		}
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		if (cellHeight > 0 && list.getFixedCellHeight() != cellHeight)
		{
			list.setFixedCellHeight(cellHeight);
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
			setIcon((Icon) value);
		}
		else
		{
			if (value != null)
			{	
				setText(value.toString());
				setToolTipText(value.toString());
			}
			if (cellIcon != null)
			{
				setIcon(cellIcon);
			}
		}
		if (cellBorder != null)
		{
			adaptBorder(isSelected, cellHasFocus);
		}
		
		return this;
	}
	
	private void adaptBorder(boolean isSelected, boolean cellHasFocus)
	{
		if (cellHasFocus)
		{
			if (isSelected)
			{
				if (selectionBorder == null)
				{
					selectionBorder = BorderFactory.createCompoundBorder(getBorder(), cellBorder);
				}
				setBorder(selectionBorder);
			}
			else
			{
				if (unSeletionBorder == null)
				{
					unSeletionBorder = BorderFactory.createCompoundBorder(getBorder(), cellBorder);
				}
				setBorder(unSeletionBorder);
			}
		}
		else
		{
			if (noFocusBorder == null)
			{
				noFocusBorder = BorderFactory.createCompoundBorder(getBorder(), cellBorder);
			}
			setBorder(noFocusBorder);
		}
	}
}