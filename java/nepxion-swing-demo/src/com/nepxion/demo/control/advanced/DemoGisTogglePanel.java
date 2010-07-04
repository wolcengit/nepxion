package com.nepxion.demo.control.advanced;

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
import com.nepxion.demo.component.gis.google.DemoGisPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoGisTogglePanel
	extends DemoTogglePanel
{
	public DemoGisTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("GIS", IconFactory.getSwingIcon("component/ui_defaults_16.png"), new DemoToggleTemplate(new DemoGisPanel()), "GIS");				
	}
	
	public String getToggleName()
	{
		return "GIS";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/ui_defaults_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/ui_defaults_32.png");
	}
	
	public String getToggleDescription()
	{
		return "GIS";
	}
}