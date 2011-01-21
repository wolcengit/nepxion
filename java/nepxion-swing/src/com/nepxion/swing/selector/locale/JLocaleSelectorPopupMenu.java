package com.nepxion.swing.selector.locale;

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

public abstract class JLocaleSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements ILocaleSelectorComponent
{
	private JLocaleSelector localeSelector;
	private JPanel layoutPanel;
	
	public JLocaleSelectorPopupMenu(JLocaleSelector localeSelector, AbstractButton button)
	{		
		this.localeSelector = localeSelector;		
		this.localeSelector.setPreferredSize(new Dimension(220, localeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/locale_48.png"));
		optionPanel.setComponent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(localeSelector.getPreferredSize().width + 90);
		setPopupMenuHeight(localeSelector.getPreferredSize().height + 95);
		setResizable(false);
	}
	
	public JLocaleSelector getLocaleSelector()
	{
		return localeSelector;
	}
	
	public void setLocaleSelector(JLocaleSelector localeSelector)
	{
		this.localeSelector = localeSelector;
		this.localeSelector.setPreferredSize(new Dimension(220, this.localeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(localeSelector);
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
			return JLocaleSelectorPopupMenu.this.confirm();
		}
		
		public boolean cancel()
		{
			return JLocaleSelectorPopupMenu.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}