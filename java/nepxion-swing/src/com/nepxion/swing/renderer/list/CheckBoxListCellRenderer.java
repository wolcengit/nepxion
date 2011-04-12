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
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nepxion.swing.element.IElementNode;

public class CheckBoxListCellRenderer
	extends CheckBoxCellRendererPanel implements ListCellRenderer
{
	private JList list;
	private int fixedCellHeight = -1;
	
	private JCheckBox checkBox;
	private CellRendererLabel cellLabel;
	
	public CheckBoxListCellRenderer(JList list)
	{
		this(list, -1);
	}
	
	public CheckBoxListCellRenderer(JList list, int fixedCellHeight)
	{
		this.list = list;
		this.fixedCellHeight = fixedCellHeight;
		
		checkBox = getCheckBox();
		cellLabel = getLabel();
		
		if (list != null && fixedCellHeight > 0)
		{
			list.setFixedCellHeight(fixedCellHeight);
		}
		list.addListSelectionListener(new CheckBoxListSelectionListener());
		list.addMouseListener(new CheckBoxListMouseListener());
	}
	
	public JList getList()
	{
		return list;
	}
	
	public void setList(JList list)
	{
		this.list = list;
	}
	
	public int getFixedCellHeight()
	{
		return fixedCellHeight;
	}
	
	public void setFixedCellHeight(int fixedCellHeight)
	{
		this.fixedCellHeight = fixedCellHeight;
		
		if (list != null && fixedCellHeight > 0)
		{
			list.setFixedCellHeight(fixedCellHeight);
		}
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus)
	{
		IElementNode elementNode = (IElementNode) value;
		checkBox.setSelected(elementNode.isSelected());
		cellLabel.setText(elementNode.getText());
		cellLabel.setIcon(elementNode.getIcon());
		cellLabel.setToolTipText(elementNode.getToolTipText());
		cellLabel.setSelected(isSelected);
		cellLabel.setFont(list.getFont());
		cellLabel.setFocus(hasFocus);
		cellLabel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
		cellLabel.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
		
		setToolTipText(elementNode.getToolTipText());
		
		return this;
	}
	
	public class CheckBoxListSelectionListener
		implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			adaptSelection();
		}
	}
	
	public class CheckBoxListMouseListener
		extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			adaptSelection();
		}
	}
	
	private void adaptSelection()
	{
		int[] indexes = list.getSelectedIndices();
		if (indexes.length > 1)
		{
			boolean selected = false;
			for (int i = 0; i < indexes.length; i++)
			{
				int index = indexes[i];
				IElementNode elementNode = (IElementNode) list.getModel().getElementAt(index);
				if (i == 0)
				{
					selected = elementNode.isSelected();
				}
				elementNode.setSelected(selected);
				Rectangle rectangle = list.getCellBounds(index, index);
				list.repaint(rectangle);
			}
		}
		else
		{
			int index = list.getSelectedIndex();
			if (index > -1)
			{
				IElementNode elementNode = (IElementNode) list.getModel().getElementAt(index);
				elementNode.setSelected(!elementNode.isSelected());
				Rectangle rectangle = list.getCellBounds(index, index);
				list.repaint(rectangle);
			}
		}
	}
}