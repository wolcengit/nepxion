package com.nepxion.demo.common;

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

import javax.swing.BorderFactory;

import com.nepxion.swing.panel.toggle.AbstractTogglePanel;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public abstract class DemoTogglePanel
	extends AbstractTogglePanel
{
	private JEclipseTabbedPane toggleTabbedPane;
	
	public DemoTogglePanel()
	{
		toggleTabbedPane = new JEclipseTabbedPane();
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(0, 6, 6, 6));
		add(toggleTabbedPane, BorderLayout.CENTER);
	}
	
	public JEclipseTabbedPane getToggleTabbedPane()
	{
		return toggleTabbedPane;
	}
}