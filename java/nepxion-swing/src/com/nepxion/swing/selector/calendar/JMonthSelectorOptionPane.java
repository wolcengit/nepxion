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

import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JMonthSelectorOptionPane
	extends JBasicOptionPane implements IMonthSelectorComponent
{
	private Component owner;
	private JMonthSelector monthSelector;
	private JPanel layoutPanel;
	
	public JMonthSelectorOptionPane(Component owner, JMonthSelector monthSelector)
	{
		this.owner = owner;
		this.monthSelector = monthSelector;
		this.monthSelector.setPreferredSize(new Dimension(180, monthSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(monthSelector, BorderLayout.NORTH);
	}
	
	public int showMonthDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("month_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	public JMonthSelector getMonthSelector()
	{
		return monthSelector;
	}
	
	public void setMonthSelector(JMonthSelector monthSelector)
	{
		this.monthSelector = monthSelector;
		this.monthSelector.setPreferredSize(new Dimension(180, this.monthSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(monthSelector);
	}
}