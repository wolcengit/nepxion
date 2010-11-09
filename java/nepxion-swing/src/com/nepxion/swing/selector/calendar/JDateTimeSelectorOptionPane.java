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

public class JDateTimeSelectorOptionPane
	extends JBasicOptionPane implements IDateTimeSelectorComponent
{
	private Component parentComponent;
	private JDateTimeSelector dateTimeSelector;
	private JPanel layoutPanel;
	
	public JDateTimeSelectorOptionPane(Component parentComponent)
	{
		this.parentComponent = parentComponent;
		
		dateTimeSelector = new JDateTimeSelector();
		dateTimeSelector.setPreferredSize(new Dimension(250, dateTimeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateTimeSelector, BorderLayout.NORTH);
	}
	
	public int showDateDialog()
	{
		return showDialog(parentComponent, layoutPanel, SwingLocale.getString("date_time_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	public JDateTimeSelector getDateTimeSelector()
	{
		return dateTimeSelector;
	}
	
	public void setDateTimeSelector(JDateTimeSelector dateTimeSelector)
	{
		this.dateTimeSelector = dateTimeSelector;
		this.dateTimeSelector.setPreferredSize(new Dimension(250, this.dateTimeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(dateTimeSelector);
	}
}