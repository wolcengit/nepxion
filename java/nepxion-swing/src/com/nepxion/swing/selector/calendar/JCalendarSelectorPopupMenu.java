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

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.panel.option.JOptionPanel;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownDraggablePopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;

public abstract class JCalendarSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements ICalendarSelectorComponent
{
	private JCalendarSelector calendarSelector;
	private JPanel layoutPanel;
	
	public JCalendarSelectorPopupMenu(JCalendarSelector calendarSelector, AbstractButton button)
	{
		this.calendarSelector = calendarSelector;
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(calendarSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setComponent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(calendarSelector.getPreferredSize().width + 90);
		setPopupMenuHeight(calendarSelector.getPreferredSize().height + 75);
		setResizable(false);
	}
	
	public JCalendarSelector getCalendarSelector()
	{
		return calendarSelector;
	}
	
	public void setCalendarSelector(JCalendarSelector calendarSelector)
	{
		this.calendarSelector = calendarSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(calendarSelector);
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
			return JCalendarSelectorPopupMenu.this.confirm();
		}
		
		public boolean cancel()
		{
			return JCalendarSelectorPopupMenu.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}