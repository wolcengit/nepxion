package com.nepxion.swing.combobox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.renderer.combobox.ComboBoxGroupCellRenderer;

public class JGroupComboBox
	extends JBasicComboBox
{
	public JGroupComboBox(ComboBoxModel aModel)
	{
		super(aModel);
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	public JGroupComboBox(final Object items[])
	{
		super(items);
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	public JGroupComboBox(Vector items)
	{
		super(items);
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	public JGroupComboBox()
	{
		super();
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	public class ComboBoxGroupActionListener
		implements ActionListener
	{
		private Object currentItem;
		
		public ComboBoxGroupActionListener()
		{
			setSelectedIndex(0);
			currentItem = getSelectedItem();
		}
		
		public void actionPerformed(ActionEvent e)
		{
			Object selectedItem = getSelectedItem();
			
			if (selectedItem instanceof IElementNode)
			{
				IElementNode elementNode = (IElementNode) selectedItem;
				if (!elementNode.isEnabled())
				{
					setSelectedItem(currentItem);
					return;
				}
			}
			if (selectedItem.toString().equals(ComboBoxGroupCellRenderer.SEPARATOR))
			{
				setSelectedItem(currentItem);
				return;
			}
			
			currentItem = selectedItem;
		}
	}
}