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

import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nepxion.swing.element.IElementNode;

public class RadioButtonListCellRenderer
	extends RadioButtonCellRendererPanel implements ListCellRenderer
{
	private JList list;
	private int fixedCellHeight = -1;
	
	private JRadioButton radioButton;
	private CellRendererLabel cellLabel;
	
	public RadioButtonListCellRenderer(JList list)
	{
		this(list, -1);
	}
	
	public RadioButtonListCellRenderer(JList list, int fixedCellHeight)
	{
		this.list = list;
		this.fixedCellHeight = fixedCellHeight;
		
		radioButton = getRadioButton();
		cellLabel = getLabel();
		
		if (list != null && fixedCellHeight > 0)
		{
			list.setFixedCellHeight(fixedCellHeight);
		}
		list.addListSelectionListener(new RadioButtonListSelectionListener());
		list.addMouseListener(new RadioButtonListMouseListener());
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
		radioButton.setSelected(elementNode.isSelected());
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
	
	public class RadioButtonListSelectionListener
		implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			adaptSelection();
		}
	}
	
	public class RadioButtonListMouseListener
		extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			adaptSelection();
		}
	}
	
	private void adaptSelection()
	{
		int index = list.getSelectedIndex();
		if (index > -1)
		{
			for (int i = 0; i < list.getModel().getSize(); i++)
			{
				IElementNode elementNode = (IElementNode) list.getModel().getElementAt(i);
				if (index == i)
				{
					if (!elementNode.isSelected())
					{
						elementNode.setSelected(true);
					}
				}
				else
				{
					elementNode.setSelected(false);
				}
				Rectangle rectangle = list.getCellBounds(i, i);
				list.repaint(rectangle);
			}
		}
	}
}