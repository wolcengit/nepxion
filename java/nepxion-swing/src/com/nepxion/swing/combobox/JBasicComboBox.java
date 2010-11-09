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

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboPopup;

import com.nepxion.swing.dimension.DimensionManager;

public class JBasicComboBox
	extends JComboBox
{
	private int popupMenuWidth = 0;
	private boolean isPopupMenuShowUp = false;
	
	public JBasicComboBox(ComboBoxModel aModel)
	{
		super(aModel);
		
		initComponents();
	}
	
	public JBasicComboBox(final Object items[])
	{
		super(items);
		
		initComponents();
	}
	
	public JBasicComboBox(Vector items)
	{
		super(items);
		
		initComponents();
	}
	
	public JBasicComboBox()
	{
		super();
		
		initComponents();
	}
	
	private void initComponents()
	{
		ComboBoxManager.setPreferenceStyle(this);
	}
	
	public void setEditable(boolean editable)
	{
		super.setEditable(editable);
		
		setFocusable(true);
	}
	
	public int getPopupMenuWidth()
	{
		return popupMenuWidth;
	}
	
	public void setPopupMenuWidth(int popupMenuWidth)
	{
		this.popupMenuWidth = popupMenuWidth;
	}
	
	public boolean isPopupMenuShowUp()
	{
		return isPopupMenuShowUp;
	}
	
	public void setPopupMenuShowUp(boolean isPopupMenuShowUp)
	{
		this.isPopupMenuShowUp = isPopupMenuShowUp;
	}
	
	public void firePopupMenuWillBecomeVisible()
	{
		if (popupMenuWidth > 0 || isPopupMenuShowUp)
		{
			BasicComboPopup comboPopup = (BasicComboPopup) getUI().getAccessibleChild(this, 0);
			JScrollPane scrollPane = (JScrollPane) comboPopup.getComponent(0);
			if (popupMenuWidth > 0)
			{
				Dimension popupSize = new Dimension(popupMenuWidth, comboPopup.getPreferredSize().height);
				DimensionManager.setDimension(scrollPane, popupSize);
			}
			
			if (isPopupMenuShowUp)
			{
				int height = comboPopup.getHeight();
				if (height == 0)
				{
					height = comboPopup.getPreferredSize().height;
				}
				comboPopup.setLocation(getLocationOnScreen().x, getLocationOnScreen().y - height);
			}
		}
		super.firePopupMenuWillBecomeVisible();
	}
}