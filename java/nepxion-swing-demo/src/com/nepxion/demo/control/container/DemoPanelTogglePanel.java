package com.nepxion.demo.control.container;

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
import com.nepxion.demo.component.panel.DemoButtonPanel;
import com.nepxion.demo.component.panel.DemoIPPropertyPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoPanelTogglePanel
	extends DemoTogglePanel
{
	public DemoPanelTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Button Panel", IconFactory.getSwingIcon("component/panel_16.png"), new DemoToggleTemplate(new DemoButtonPanel()));		
		toggleTabbedPane.addTab("IP Property Panel", IconFactory.getSwingIcon("component/panel_16.png"), new DemoToggleTemplate(new DemoIPPropertyPanel()));
	}
	
	public String getToggleName()
	{
		return "Panel";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/panel_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/panel_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Panel";
	}
}