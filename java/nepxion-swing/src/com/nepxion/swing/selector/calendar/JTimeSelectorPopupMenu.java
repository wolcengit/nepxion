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

public abstract class JTimeSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements ITimeSelectorComponent
{
	private JTimeSelector timeSelector;
	private JPanel layoutPanel;
	
	public JTimeSelectorPopupMenu(JTimeSelector timeSelector, AbstractButton button)
	{		
		this.timeSelector = timeSelector;		
		this.timeSelector.setPreferredSize(new Dimension(180, timeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setComponent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(timeSelector.getPreferredSize().width + 90);
		setPopupMenuHeight(timeSelector.getPreferredSize().height + 95);
		setResizable(false);
	}
	
	public JTimeSelector getTimeSelector()
	{
		return timeSelector;
	}
	
	public void setTimeSelector(JTimeSelector timeSelector)
	{
		this.timeSelector = timeSelector;
		this.timeSelector.setPreferredSize(new Dimension(180, this.timeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(timeSelector);
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
			return JTimeSelectorPopupMenu.this.confirm();
		}
		
		public boolean cancel()
		{
			return JTimeSelectorPopupMenu.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}