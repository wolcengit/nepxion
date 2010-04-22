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
import com.nepxion.demo.component.layout.filed.DemoColumnFiledLayoutPanel;
import com.nepxion.demo.component.layout.filed.DemoRowFiledLayoutPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoFiledLayoutTogglePanel
	extends DemoTogglePanel
{
	public DemoFiledLayoutTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Row Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoRowFiledLayoutPanel()));		
		toggleTabbedPane.addTab("Column Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoColumnFiledLayoutPanel()));
	}
	
	public String getToggleName()
	{
		return "Filed Layout";
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
		return "Filed Layout";
	}
}