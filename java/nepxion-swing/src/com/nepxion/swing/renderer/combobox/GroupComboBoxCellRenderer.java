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
import javax.swing.JSeparator;
import javax.swing.border.Border;

import com.nepxion.swing.element.IElementNode;

public class GroupComboBoxCellRenderer
	extends ElementComboBoxCellRenderer
{
	public static final String SEPARATOR = "#Separator"; // Item的Text可能为"Separator"， 故在前面加个#， 以做特殊标志位区分
	
	private JSeparator separator;
	
	public GroupComboBoxCellRenderer()
	{
		super();
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public GroupComboBoxCellRenderer(int fixedCellHeight)
	{
		super(fixedCellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public GroupComboBoxCellRenderer(Icon cellIcon)
	{
		super(cellIcon);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public GroupComboBoxCellRenderer(Border cellBorder)
	{
		super(cellBorder);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public GroupComboBoxCellRenderer(Icon cellIcon, int fixedCellHeight)
	{
		super(cellIcon, fixedCellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public GroupComboBoxCellRenderer(Border cellBorder, int fixedCellHeight)
	{
		super(cellBorder, fixedCellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public GroupComboBoxCellRenderer(Border cellBorder, Icon cellIcon)
	{
		super(cellBorder, cellIcon);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public GroupComboBoxCellRenderer(Border cellBorder, Icon cellIcon, int fixedCellHeight)
	{
		super(cellBorder, cellIcon, fixedCellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		if (value instanceof IElementNode)
		{
			IElementNode elementNode = (IElementNode) value;
			/*if (!elementNode.isEnabled())
			{
				setForeground(UIManager.getColor("Label.disabledForeground"));
			}*/
			
			setEnabled(elementNode.isEnabled());
		}
		
		if (value.toString().equals(SEPARATOR))
		{
			return separator;
		}
		
		return this;
	}
}