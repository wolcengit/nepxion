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

public abstract class JDateSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements IDateSelectorComponent
{
	private JDateSelector dateSelector;
	private JPanel layoutPanel;
	
	public JDateSelectorPopupMenu(AbstractButton button)
	{
		setResizable(false);
		
		dateSelector = new JDateSelector();
		dateSelector.setPreferredSize(new Dimension(180, dateSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setComponent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(dateSelector.getPreferredSize().width + 90);
		setPopupMenuHeight(dateSelector.getPreferredSize().height + 95);
	}
	
	public JDateSelector getDateSelector()
	{
		return dateSelector;
	}
	
	public void setDateSelector(JDateSelector dateSelector)
	{
		this.dateSelector = dateSelector;
		this.dateSelector.setPreferredSize(new Dimension(180, this.dateSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(dateSelector);
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
			return JDateSelectorPopupMenu.this.confirm();
		}
		
		public boolean cancel()
		{
			return JDateSelectorPopupMenu.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}