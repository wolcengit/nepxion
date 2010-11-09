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

public class JTimeSelectorOptionPane
	extends JBasicOptionPane implements ITimeSelectorComponent
{
	private Component parentComponent;
	private JTimeSelector timeSelector;
	private JPanel layoutPanel;
	
	public JTimeSelectorOptionPane(Component parentComponent)
	{
		this.parentComponent = parentComponent;
		
		timeSelector = new JTimeSelector();
		timeSelector.setPreferredSize(new Dimension(180, timeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
	}
	
	public int showTimeDialog()
	{
		return showDialog(parentComponent, layoutPanel, SwingLocale.getString("time_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
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
}