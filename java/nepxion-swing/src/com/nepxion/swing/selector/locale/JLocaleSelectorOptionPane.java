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

import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JLocaleSelectorOptionPane
	extends JBasicOptionPane implements ILocaleSelectorComponent
{
	private Component owner;
	private JLocaleSelector localeSelector;
	private JPanel layoutPanel;
	
	public JLocaleSelectorOptionPane(Component owner, JLocaleSelector localeSelector)
	{
		this.owner = owner;
		this.localeSelector = localeSelector;
		this.localeSelector.setPreferredSize(new Dimension(220, localeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
	}
	
	public int showLocaleDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("locale_selector"), IconFactory.getSwingIcon("component/locale_48.png"));
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
}