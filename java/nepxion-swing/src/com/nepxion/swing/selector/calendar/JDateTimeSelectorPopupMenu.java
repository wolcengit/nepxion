package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.panel.option.JOptionPanel;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownDraggablePopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;

public abstract class JDateTimeSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements IDateTimeSelectorComponent
{
	private JDateTimeSelector dateTimeSelector;
	private JPanel layoutPanel;
	
	public JDateTimeSelectorPopupMenu(AbstractButton button)
	{
		setResizable(false);
		
		dateTimeSelector = new JDateTimeSelector();
		dateTimeSelector.setPreferredSize(new Dimension(250, dateTimeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateTimeSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setComponent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(dateTimeSelector.getPreferredSize().width + 90);
		setPopupMenuHeight(dateTimeSelector.getPreferredSize().height + 95);
	}
	
	public JDateTimeSelector getDateTimeSelector()
	{
		return dateTimeSelector;
	}
	
	public void setDateTimeSelector(JDateTimeSelector dateTimeSelector)
	{
		this.dateTimeSelector = dateTimeSelector;
		this.dateTimeSelector.setPreferredSize(new Dimension(250, this.dateTimeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(dateTimeSelector);
	}
	
	public class DropDownPane
		extends JDropDownPane
	{
		public DropDownPane(IDropDownPopupMenu popupMenu, Component contentPane)
		{
			super(popupMenu, contentPane);
		}
		
		public boolean confirm()
		{
			return JDateTimeSelectorPopupMenu.this.confirm();
		}
		
		public boolean cancel()
		{
			return JDateTimeSelectorPopupMenu.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}