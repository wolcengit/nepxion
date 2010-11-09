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

public class JDaySelectorOptionPane
	extends JBasicOptionPane implements IDaySelectorComponent
{
	private Component parentComponent;
	private JDaySelector daySelector;
	private JPanel layoutPanel;
	
	public JDaySelectorOptionPane(Component parentComponent)
	{
		this.parentComponent = parentComponent;
		
		daySelector = new JDaySelector(true);
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(daySelector, BorderLayout.NORTH);
	}
	
	public int showDayDialog()
	{
		return showDialog(parentComponent, layoutPanel, SwingLocale.getString("day_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	public JDaySelector getDaySelector()
	{
		return daySelector;
	}
	
	public void setDaySelector(JDaySelector daySelector)
	{
		this.daySelector = daySelector;
		this.daySelector.setPreferredSize(new Dimension(180, this.daySelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(daySelector);
	}
}