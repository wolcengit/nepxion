package com.nepxion.demo.control.bar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Icon;

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.demo.component.button.DemoButtonPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoStatusBarTogglePanel
	extends DemoTogglePanel
{
	public DemoStatusBarTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		// toggleTabbedPane.addTab("Button", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoButtonPanel()));
	}
	
	public String getToggleName()
	{
		return "StatusBar";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style StatusBar";
	}
}