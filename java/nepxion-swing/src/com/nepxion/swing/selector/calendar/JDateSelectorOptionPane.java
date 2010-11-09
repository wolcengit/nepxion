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

public class JDateSelectorOptionPane
	extends JBasicOptionPane implements IDateSelectorComponent
{
	private Component parentComponent;
	private JDateSelector dateSelector;
	private JPanel layoutPanel;
	
	public JDateSelectorOptionPane(Component parentComponent)
	{
		this.parentComponent = parentComponent;
		
		dateSelector = new JDateSelector();
		dateSelector.setPreferredSize(new Dimension(180, dateSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
	}
	
	public int showDateDialog()
	{
		return showDialog(parentComponent, layoutPanel, SwingLocale.getString("date_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
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
}