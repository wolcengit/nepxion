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

import com.nepxion.swing.framework.ribbon.IRibbonComponent;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.toggle.JTogglePanel;

public abstract class DemoTogglePanel
	extends JTogglePanel implements IRibbonComponent
{	
	private JEclipseTabbedPane toggleTabbedPane;
	
	public DemoTogglePanel()
	{
		toggleTabbedPane = new JEclipseTabbedPane();
		
		setLayout(new BorderLayout());
		add(toggleTabbedPane, BorderLayout.CENTER);
	}
	
	public JEclipseTabbedPane getToggleTabbedPane()
	{
		return toggleTabbedPane;
	}
	
	public Object getUserObject()
	{
		return null;
	}

	public void setUserObject(Object userObject)
	{
		
	}
}