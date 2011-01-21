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

public abstract class JYearSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements IYearSelectorComponent
{
	private JYearSelector yearSelector;
	private JPanel layoutPanel;
	
	public JYearSelectorPopupMenu(JYearSelector yearSelector, AbstractButton button)
	{		
		this.yearSelector = yearSelector;		
		this.yearSelector.setPreferredSize(new Dimension(180, yearSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(yearSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setComponent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(yearSelector.getPreferredSize().width + 90);
		setPopupMenuHeight(yearSelector.getPreferredSize().height + 95);
		setResizable(false);
	}
	
	public JYearSelector getYearSelector()
	{
		return yearSelector;
	}
	
	public void setYearSelector(JYearSelector yearSelector)
	{
		this.yearSelector = yearSelector;
		this.yearSelector.setPreferredSize(new Dimension(180, this.yearSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(yearSelector);
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
			return JYearSelectorPopupMenu.this.confirm();
		}
		
		public boolean cancel()
		{
			return JYearSelectorPopupMenu.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}