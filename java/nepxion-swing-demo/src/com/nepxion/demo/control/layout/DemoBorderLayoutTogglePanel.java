package com.nepxion.demo.control.layout;

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
import com.nepxion.demo.component.layout.border.DemoBorderLayoutPanel;
import com.nepxion.demo.component.layout.border.DemoXBorderLayoutPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoBorderLayoutTogglePanel
	extends DemoTogglePanel
{
	public DemoBorderLayoutTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("XBorder", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoXBorderLayoutPanel()), "XBorder");				
		toggleTabbedPane.addTab("Border", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoBorderLayoutPanel()), "Border");
	}
	
	public String getToggleName()
	{
		return "XBorder Layout";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/layout_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/layout_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style XBorder Layout";
	}
}