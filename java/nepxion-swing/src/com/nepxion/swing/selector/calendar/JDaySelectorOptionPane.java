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

import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JDaySelectorOptionPane
	extends JBasicOptionPane implements IDaySelectorComponent
{
	private Component owner;
	private JDaySelector daySelector;
	private JPanel layoutPanel;
	
	public JDaySelectorOptionPane(Component owner, JDaySelector daySelector)
	{
		this.owner = owner;
		this.daySelector = daySelector;
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(daySelector, BorderLayout.NORTH);
	}
	
	public int showDayDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("day_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	public JDaySelector getDaySelector()
	{
		return daySelector;
	}
	
	public void setDaySelector(JDaySelector daySelector)
	{
		this.daySelector = daySelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(daySelector);
	}
}