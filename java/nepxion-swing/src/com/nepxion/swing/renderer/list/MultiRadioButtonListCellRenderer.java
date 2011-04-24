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

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.locale.SwingLocale;

public class MultiRadioButtonListCellRenderer
	extends MultiRadioButtonCellRendererPanel implements ListCellRenderer
{
	private JList list;
	private int fixedCellHeight = -1;
	
	private CellRendererLabel cellLabel;
	
	private JRadioButton ignoredRadioButton;
	private JRadioButton containedRadioButton;
	private JRadioButton notContainedRadioButton;
	
	public MultiRadioButtonListCellRenderer(JList list)
	{
		this(list, -1);
	}
	
	public MultiRadioButtonListCellRenderer(JList list, int fixedCellHeight)
	{
		this(list, fixedCellHeight, SwingLocale.getString("select_ignored"), SwingLocale.getString("select_contained"), SwingLocale.getString("select_not_contained"));
	}
	
	public MultiRadioButtonListCellRenderer(JList list, String ignoredText, String containedText, String notContainedText)
	{
		this(list, -1, ignoredText, containedText, notContainedText);
	}
	
	public MultiRadioButtonListCellRenderer(JList list, int fixedCellHeight, String ignoredText, String containedText, String notContainedText)
	{
		super(ignoredText, containedText, notContainedText);
		
		this.list = list;
		this.fixedCellHeight = fixedCellHeight;
		
		cellLabel = getLabel();
		ignoredRadioButton = getIgnoredRadioButton();
		containedRadioButton = getContainedRadioButton();
		notContainedRadioButton = getNotContainedRadioButton();
		
		if (list != null && fixedCellHeight > 0)
		{
			list.setFixedCellHeight(fixedCellHeight);
		}
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

		switch (elementNode.getSelectedIndex())
		{
			case IElementNode.SELECTION_INDEX_IGNORED :
			{
				ignoredRadioButton.setSelected(true);
				break;
			}
			case IElementNode.SELECTION_INDEX_CONTAINED :
			{
				containedRadioButton.setSelected(true);
				break;
			}	
			case IElementNode.SELECTION_INDEX_NOT_CONTAINED :
			{
				notContainedRadioButton.setSelected(true);
				break;
			}	
		}
		
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
	
	public class RadioButtonListMouseListener
		extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			adaptSelection(e.getX());
		}
	}
	
	private void adaptSelection(int x)
	{
		int index = list.getSelectedIndex();
		if (index > -1)
		{			
			int selectedRadioIndex = getSelectedRadioIndex(x);
			if (selectedRadioIndex > -1)
			{	
				IElementNode elementNode = (IElementNode) list.getModel().getElementAt(index);
				elementNode.setSelectedIndex(selectedRadioIndex);
				Rectangle rectangle = list.getCellBounds(index, index);
				list.repaint(rectangle);
			}
		}
	}
}